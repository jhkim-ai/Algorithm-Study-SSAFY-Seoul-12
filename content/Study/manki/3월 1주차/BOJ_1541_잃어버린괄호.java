// https://www.acmicpc.net/problem/1541
// 잃어버린괄호
// Greedy
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1541 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// -를 기준으로 먼저 분리.
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		int sum = Integer.MAX_VALUE;
		
		while(sub.hasMoreTokens()) {

			int temp = 0;
			// +기준으로 분리
			StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
			
			// +인 것들을 먼저 모두 더해 준 후에! 뺄셈 연산을 해주면 최솟값을 만들 수 있다.
			while(add.hasMoreTokens()) {
				temp+=Integer.parseInt(add.nextToken());
			}
			
			// 첫 값이 없을 때
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum-=temp;
			}
		}
		
		System.out.print(sum);
	}
}