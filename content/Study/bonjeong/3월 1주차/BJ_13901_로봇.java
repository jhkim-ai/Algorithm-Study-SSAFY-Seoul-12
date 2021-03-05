package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13901_로봇 {
	static int[][] graph;
	static int[] dir;
	static boolean[][] visited;
	
	static int R;
	static int C;

	static int sr;
	static int sc;
	
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new int[R+1][C+1];
		visited = new boolean[R+1][C+1];
		
		int K = Integer.parseInt(br.readLine()); 
		for(int k= 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int brr = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());
			visited[brr][bc] = true; // 장애물 지역 방문처리
		}
		
		st = new StringTokenizer(br.readLine());
		
		int sr = Integer.parseInt(st.nextToken()); // 시작위치 r
		int sc = Integer.parseInt(st.nextToken()); // 시작위치 c
		
		// 이동 방향 dir 배열에 저장 
		dir = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i < 4; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}

		visited[sr][sc] = true; //시작좌표 방문처리 하고
		move(sr, sc); // 시작좌표 넘겨주면서 move!
	}
	
	
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int cnt;
	static int nr;
	static int nc;
	static void move(int sr, int sc) {		
		
		int d = 0;
		
		while(true) {
			// 한 칸 이동
			// dir: 1 2 3 4 
			nr = sr + deltas[dir[d]-1][0];
			nc = sc + deltas[dir[d]-1][1];
			
//			System.out.println(nr + "," + nc);
			
			// 벽 만나면 다음 방향 이동 방문한 지역이나 장애물 만나면 다음 방향 이동
			if((nr < 0 || nc < 0 || nr >=R || nc >= C) || visited[nr][nc] == true) {
				cnt++;
				d++;
				
				// d가 4 이상 되면 다시 0으로 줄여주기
				if(d == 4) {
					d = d % 4;
				}
				
				 // 4번 이동하는 동안 계속 벽/장애물/방문지역 만나면 더이상 움직일 수 없음
				if(cnt == 4)
					break;
			}
			
			// 이동 가능하면 계속 이동
			else {
				sr = nr;
				sc = nc;
				visited[nr][nc] = true;
				cnt = 0;
			}
		}
		
//		System.out.println("sr, sc: " + sr + "," + sc);
		System.out.println(sr + " " + sc);
	}

}
