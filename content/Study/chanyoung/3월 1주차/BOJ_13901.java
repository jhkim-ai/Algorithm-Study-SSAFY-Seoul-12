// 13901, 로봇 | https://www.acmicpc.net/problem/13901
// 12,596KB | 104ms
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_13901 {

	static int R, C, k, bbr, bbc, sr, sc;
	static int[][] deltas = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] dx = new int[4];
	static int[] dy = new int[4];
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// map 초기화 - '*'으로 채워둔다.
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], '*');
		}
		// 장애물 개수, 위치
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			bbr = Integer.parseInt(st.nextToken());
			bbc = Integer.parseInt(st.nextToken());
			map[bbr][bbc] = 'x';
		}
		// 시작 위치
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		// 방향 설정
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int d = Integer.parseInt(st.nextToken());
			dx[i] = deltas[d][0];
			dy[i] = deltas[d][1];
		}

		int[] res = new int[2];
		res = move();
		System.out.println(res[0]+" "+res[1]);
	}

	static int[] move() {
		
		int x = sr, y = sc, d = 0;
		map[x][y] = 'v';
		while (true) {
			//System.out.println("now_x: "+x+" now_y: "+y);
			// 벽 or 방문한 지역 or 장애물 -> 방향 전환
			if (!isIn(x + dx[d], y + dy[d]) || map[x + dx[d]][y + dy[d]] != '*') {
				int startD = d;
				d += 1;
				d %= 4;
				//System.out.println("*방향 전환: "+d);
				//System.out.println(x+dx[d]+" "+(y+dy[d]));
				while (!isIn(x + dx[d], y + dy[d]) || map[x + dx[d]][y + dy[d]] != '*') {
					d++;
					d %= 4;
					//System.out.println("**방향 전환: "+d);
					
					// 방향 바꾸다가 원래 방향으로 돌아오면 움직이지 못 하는 것 -> 위치 반환
					if (d == startD) {
						return new int[] { x, y };
					}
				}
			}

			int nx = x + dx[d];
			int ny = y + dy[d];
			map[nx][ny] = 'v'; // 방문 처리
			x=nx;
			y=ny;
			//print();
		}

	}
	
	// 범위 내에 존재하는지 확인
	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
	
	static void print() {
		for (char[] row: map) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
	
	
}

