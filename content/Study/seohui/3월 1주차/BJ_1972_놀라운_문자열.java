package com.BaekJoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1972_놀라운_문자열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	
	static char [] line; // 문자열을 담을 배열
	static String st; // D-쌍의 문자열을 담을 문자열
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		while(true) {
			String s = input.readLine();
			int n = s.length();
			
			//만약 문자가 하나라면 1. *종료 문자열 이거나 2. 한 문자로 완벽한 문자열이거나
			if(n ==1) {
				if(s.charAt(0)=='*') {
					break;
				}
				else
					output.append(s.charAt(0)).append(" is surprising.").append("\n");
				continue;
			}
			else {
				line = new char [n]; 
				for(int i = 0;i<n; i++) {
					line[i] = s.charAt(i);
				}
				int a = line.length;
				boolean flag = true; // 놀라운 문자열인지 판별
				out:for(int j = 1; j < a-1; j++) { //0~n-2 쌍을 봐야 하므로 인덱스 주의
					List<String> arr = new LinkedList<String>(); //몇 개의 쌍이 나올지 알수 없으므로 리스트로 선언한다.
					for(int i = 0; i<a-j; i++) {
						char c = line[i];
						char c2 = line[i+j];
						st = ""; //빈 문자열에
						st += c; // 쌍이될 문자열의 첫문자
						st += c2; // 다음 문자
						if(arr.contains(st)) { // 이미 있는 문자열이라면 놀라운 문자열이 아님 더이상 보지 않아도 됨
							flag = false;
							output.append(s).append(" is NOT surprising").append("\n");
							break out;
						}
						else	arr.add(st); // 아니라면 확인하기 위해 문자열을 담는다.

					}
					
				}
				if(flag) // 앞선 if에 한 번도 걸리지 않았다면 놀라운 문자열
					output.append(s).append(" is surprising").append("\n");
			}
			
			
			
		}
		System.out.println(output);
	}
	static String src="ZGBG\r\n" + 
			"X\r\n" + 
			"EE\r\n" + 
			"AAB\r\n" + 
			"AABA\r\n" + 
			"AABB\r\n" + 
			"BCBABCC\r\n" + 
			"*";
}
