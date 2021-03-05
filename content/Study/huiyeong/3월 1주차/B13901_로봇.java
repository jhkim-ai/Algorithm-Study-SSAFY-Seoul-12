package BOJ.Silver.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13901_로봇 {
	static int R, C, sr, sc, count;
	static int[][] map;
	static int[][] deltas = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 1: 상, 2: 하, 3: 좌, 4: 우
	static int[] dir;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 장애물
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		map[sr][sc] = 1; // 로봇 초기 위치 방문표시
		dir = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<4;i++) {
			dir[i] = Integer.parseInt(st.nextToken()); // 방향 입력
		}
		// 입력완료
		count = 0;
		loop(0);
		System.out.println(sr+" "+sc); // 로봇의 마지막 위치 출력
	}
	
	static void loop(int d) {
		while(true) {
			int nr = sr+deltas[dir[d]][0];
			int nc = sc+deltas[dir[d]][1];
			if (isIn(nr, nc) && map[nr][nc]==0) {
				map[nr][nc] = 1;
				sr = nr; sc = nc;
				count = 0;
			} else { // 가지못한다면
				d=(d+1)%4; // 다음 방향
				count++;
			}
			if (count==4) break; // 방향 다 확인하면 끝
		}
	}
	
	static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
}
