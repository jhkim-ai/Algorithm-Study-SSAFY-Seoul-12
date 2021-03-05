package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1972_놀라운문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			
			// while문 종료 조건
			if(s.charAt(0) == '*')
				break;
			
			List<String> list = new ArrayList<String>();
			
			boolean check = true;
			
			//만들 수 있는 모든 쌍 탐색
			for(int n = 1; n < s.length()-1; n++) {
				for(int c = 0; c < s.length()-n; c++) {
					String ss = "" + s.charAt(c) + s.charAt(c + n); // 0쌍부터 N-2쌍까지
					if(list.contains(ss)) {
						check = false; // 겹치는 쌍이 있으면 false
					}
					list.add(ss); 
				}
				list.clear(); // 각 D마다 list 비워주기. 
			}
			
			if(check) 
				System.out.println(s + " is surprising.");
			else
				System.out.println(s + " is NOT surprising.");
			
		}
	}
}
