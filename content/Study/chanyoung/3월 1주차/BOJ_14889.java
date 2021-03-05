// 14889, 스타트와 링크 | https://www.acmicpc.net/problem/14889
// 65,168KB | 492ms
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_14889 {

	static int N;
	static int[][] S;
	static Integer[] combs;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		// 스타트 팀이거나, 링크 팀이거나 -> 부분집합
		combs = new Integer[N / 2];		// N/2명씩 팀 이룸 -> 배열 크기 : N/2
		comb(0, 0);
		
		System.out.println(res);
	}

	static int res = Integer.MAX_VALUE;		// res: 능력치 값 최소 차이

	static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			// 1팀의 능력치 합 구한다.
			score = 0;
			comb2(0, 0, combs);
			int scoreA = score;
			
			// 1팀에 포함되어 있지 않으면 -> 2팀
			// contains 쓰기 위해 List로
			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(combs));
			// 2팀 배열
			Integer[] notSelected = new Integer[N / 2];
			
			for (int i = 0, idx = 0; i < N; i++) {
				if (!Arrays.asList(combs).contains(i)) {
					notSelected[idx++] = i;
					if (idx == N/2) break;
				}
			}
			// 2팀의 능력치 합 구한다.
			score = 0;
			comb2(0, 0, notSelected);
			int scoreB = score;
			
			// 능력치 차이의 최소값
			res = Math.min(res, Math.abs(scoreA-scoreB));
			
			return;
		}

		for (int i = start; i < N; i++) {	// 재귀로 조합
			combs[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	
	// 팀에서 두 명씩 뽑아(N/2에서 2를 뽑는 조합) 능력치 합 쌍 구해야 한다.
	static int[] combs2 = new int[2];
	static int score;
	
	static void comb2(int cnt, int start, Integer[] arr) {
		// cnt 2 되면 능력치 조사
		if (cnt == 2) {
			score += S[combs2[0]][combs2[1]];
			score += S[combs2[1]][combs2[0]];
			return;
		}

		for (int i = start; i < arr.length; i++) {	// 재귀로 조합
			combs2[cnt] = arr[i];
			comb2(cnt + 1, i + 1, arr);
		}
	}

}
