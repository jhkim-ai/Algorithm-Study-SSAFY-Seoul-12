// https://www.acmicpc.net/problem/13901
// 로봇
// 구현, 시뮬레이션
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_13901 {
 
	static final int dx[] = {0,-1,1,0,0};
	static final int dy[] = {0,0,0,-1,1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[R][C];
        int k = Integer.parseInt(br.readLine());
        
        // 장애물
        while(k-->0) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	visit[x][y] = true;
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        // 시작지점
        visit[x][y] = true;
        
        // 방향 순서
        int[] dir = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; ++i) {
        	dir[i] = Integer.parseInt(st.nextToken());
        }
        
        // 로봇 움직임
        int d = 0;
        while(true) {
        	int nx = 0;
        	int ny = 0;
        	boolean f = false;
        	for(int i = 0; i<4; ++i) {
        		nx = x+dx[dir[d]];
        		ny = y+dy[dir[d]];
        		if(nx<0||ny<0||nx==R||ny==C||visit[nx][ny]) {
        			if(++d==4) d=0;
        			continue;
        		}
        		f = true;
        		visit[nx][ny] = true;
        		break;
        	}
        	// 갈곳이 없으면 끝
        	if(!f) break;
        	// 로봇 위치 최신화
        	x=nx;y=ny;
        }
        System.out.println(x+" "+y);
    }
}