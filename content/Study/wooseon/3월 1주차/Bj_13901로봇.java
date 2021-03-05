package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_13901로봇 {

	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int r,c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int[][] map=new int[r][c];
		int x=Integer.parseInt(br.readLine()); //장애물의 개수
		
		for(int i=0;i<x;i++) {
			st=new StringTokenizer(br.readLine());
			int rb=Integer.parseInt(st.nextToken());
			int cb=Integer.parseInt(st.nextToken());
			
			map[rb][cb]=-1;
		}
		
		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		map[a][b]=-1; //시작 위치
		st=new StringTokenizer(br.readLine());
		int[] order=new int[4];
		for(int i=0;i<4;i++) {//이동순서
			order[i]=Integer.parseInt(st.nextToken());
		}
		
		//입력완료
		int dx=a; //현재위치
		int dy=b;
		int cnt=0; //4곳 다 검사했는데 지나갈 수 없는경우 체크
		for(int i=0;i<4;i++) { //탐색 방향
			int di=dx+deltas[order[i]][0];
			int dj=dy+deltas[order[i]][1];
			if(isIn(di,dj)&&map[di][dj]==0) {//범위안에 있고 장애물이 아니고,지나온곳도 아니라면
				map[di][dj]=-1; //방문
				dx=di; //현재위치 변경
				dy=dj;
				i--; //같은 방향으로 진행해야하니까
				cnt=0; 
			}
			else { //범위안에 없거나, 장애물이 있거나, 지나온곳이라면
				cnt++;
				if(cnt==4) { //4방탐색을 모두 했는데 갈곳이 없는경우
					break; //탐색중지
				}
				if(i==3) //마지막 방향순서라면
					i=-1; //다시 처음방향으로 가기 위해
			}
		}
		
		System.out.println(dx+" "+dy);
	
	}

	static boolean isIn(int i,int j) {
		return 0<=i&&i<r&&0<=j&&j<c;
	}
	
}
