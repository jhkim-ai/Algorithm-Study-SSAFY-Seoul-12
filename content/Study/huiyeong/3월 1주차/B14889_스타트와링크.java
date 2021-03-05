package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889_스타트와링크 {
	static int N, stop, sumS, sumL, MIN;
	static long cnt;
	static int[][] ability;
	static int[] startT, numbers2, linkT;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ability = new int[N+1][N+1];
		startT = new int[N/2];
		linkT = new int[N/2];
		numbers2 = new int[2];
		for (int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 조합 개수 구하기
		long p = 1;
		for (int i=N;i>N/2;i--) {
			p*=i;
		}
		long q = 1;
		for (int i=N/2;i>0;i--) {
			q*=i;
		}
		cnt=(p/q)/2;
		
		MIN = Integer.MAX_VALUE;
		combination(0, 1); // 팀 나누기
		System.out.println(MIN);
	}
	
	static void combination(int num, int start) {
		if (num==N/2) {
			stop++;
			linkT();
			return;
		}
		
		for (int i=start;i<=N;i++) {
			startT[num] = i;
			combination(num+1, i+1);
			if (stop==cnt) return; // 팀 나누기 조합 개수가 전체 조합 수의 반절이면 그만
		}
	}
	
	static void linkT() {
		sumS = 0; sumL = 0;
		int sizeS = 0, sizeL = 0;
		for (int i=1;i<=N;i++) {
			if (sizeS<N/2 && startT[sizeS]==i) sizeS++;
			else linkT[sizeL++] = i;
		}
		combination2(0, 0, startT, 'S'); // 2명씩 능력치 구하기
		combination2(0, 0, linkT, 'L'); // 2명씩 능력치 구하기
		MIN = Math.min(MIN, Math.abs(sumL-sumS));
	}
	
	static void combination2(int num, int start, int[] team, char T) {
		if (num==2) {
			diff(T);
			return;
		}
		
		for (int i=start;i<N/2;i++) {
			numbers2[num] = team[i];
			combination2(num+1, i+1, team, T);
		}
	}
	
	static void diff(char T) {
		if (T=='S') {
			sumS+=ability[numbers2[0]][numbers2[1]];
			sumS+=ability[numbers2[1]][numbers2[0]];
		} else if (T=='L') {
			sumL+=ability[numbers2[0]][numbers2[1]];
			sumL+=ability[numbers2[1]][numbers2[0]];
		}
	}
}
