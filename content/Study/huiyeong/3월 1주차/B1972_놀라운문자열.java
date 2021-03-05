package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1972_놀라운문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String word = br.readLine();
			if (word.equals("*")) break;
			
			int size = word.length();
			boolean flag = false;
			stop:for (int d=1;d<size;d++) {
				List<String> list = new ArrayList<>(); 
				for (int i=0;i+d<size;i++) {
					String temp = (word.charAt(i)+"")+(word.charAt(i+d)+"");
					list.add(temp); // i쌍 저장
				}
				for (int i=0;i<list.size();i++) { // i쌍에서 겹치는게 있는지 확인
					for (int j=i+1;j<list.size();j++) {
						if (list.get(i).equals(list.get(j))) {
							flag = true;
							break stop; 
						}
					}
				}
			}
			if (flag) sb.append(word+" is NOT surprising.\n");
			else sb.append(word+" is surprising.\n");
		}
		System.out.println(sb);
	}
}
