package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021. 3. 5.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution String s 에 char를 더해서 넣어줬더니 String이 되었다. 긴가민가하면서 해봤는데 통헀던 코드
 */

public class Bj_1972놀라운문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> s;
		StringBuilder sb=new StringBuilder();
		while(true) {
			String str=br.readLine();
			if(str.equals("*"))
				break;
			char[] ch=str.toCharArray();
			
			boolean flag=false;
			out:for(int i=0;i<=ch.length-2;i++) {
				s=new ArrayList<>();
				for(int j=0;j<ch.length;j++) {
					String st="";
					if(j+i+1<ch.length) {
						st+=ch[j];
						st+=ch[j+(i+1)];
						for(int k=0;k<s.size();k++) {
							if(s.get(k).equals(st)){
								flag=true;
								break out;
							}
						}
					}
					s.add(st);
				}
				
			}
			if(flag==false) {
				sb.append(str+" is surprising.\n");
			}
			else {
				sb.append(str+" is NOT surprising.\n");
			}
			
		}
		System.out.println(sb);

	}

}
