// https://www.acmicpc.net/problem/14889  스타트와 링크
// back tracking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_14889 {
	static int[][] board;
	static boolean[] teaming;
	static int N;
	static int ans = 100;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		teaming = new boolean[N];

		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {	
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0);
		System.out.print(ans);
	}
	
	public static void func(int x, int n) {
		if(n == N/2) {
			int team1 = 0;
			int team2 = 0;
			
			// 팀 점수를 구함
			for(int i = 0; i<N; ++i) {
				for(int j = i+1; j<N; ++j) {
					if((teaming[i]&teaming[j]) == true) {
						team1+=board[i][j]+board[j][i];
					}
					else if((teaming[i]|teaming[j]) == false) {
						team2+=board[i][j]+board[j][i];
					}
				}
			}
			
			ans = Math.min(ans, Math.abs(team1-team2));
			return;
		}
		
		// 조합을 구함
		for(int i = x; i<N; ++i) {
			teaming[i] = true;
			func(i+1, n+1);
			teaming[i] = false;
		}
	}
	
}
