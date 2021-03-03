// 1972, 놀라운 문자열 | https://www.acmicpc.net/problem/1972
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1972 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if (s.equals("*")) break;
			if (isSurprising(s)) {
				sb.append(String.format("%s is surprising.%n" , s));
			}else {
				sb.append(String.format("%s is NOT surprising.%n" , s));
			}
		}
		
		System.out.println(sb);
		
	}

	static boolean isSurprising(String s) {
//		System.out.println("s 길이: "+s.length());
		for (int i=1;i<s.length();i++) {	// D-쌍
//			System.out.println("-----------"+(i-1)+"-쌍---------");
			Set<String> set = new HashSet<>();
			for (int j=0;j<s.length()-i;j++) {
				String temp = s.substring(j, j+1);
				temp += s.substring(j+i, j+i+1);
				if (set.contains(temp))
					return false;
				set.add(temp);
//				System.out.println(temp);
			}
		
		}
		return true;
	}
}
