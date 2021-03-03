package com.BaekJoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_11021_합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		
		for(int i = 1; i<=n;i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int result = a+b;
			output.append("Case #").append(i).append(": ").append(result).append("\n");
		}
		System.out.println(output);
	}
	static String src="5\r\n" + 
			"1 1\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"9 8\r\n" + 
			"5 2";
}
