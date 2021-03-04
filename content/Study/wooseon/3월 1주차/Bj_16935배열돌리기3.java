package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_16935배열돌리기3 {

	static int N,M,R;
	static int[][] map;
	static int[][] newmap;
	static int[][] newmap1;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		int a=Math.max(N,M);
		map=new int[a+1][a+1];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int x=Integer.parseInt(st.nextToken());
			if(x==1) {
				num1();
			}
			else if(x==2) {
				num2();
			}
			else if(x==3) {
				newmap=new int[100][100]; //90도 회전후의 배열
				num3();
				int tmp=N;
				N=M;
				M=tmp;
			}
			else if(x==4){
				newmap=new int[100][100]; //90도 회전후의 배열
				num4();
				int tmp=N;
				N=M;
				M=tmp;
			}
			else if(x==5) {
				num5();	
			}
			else {
				num6();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	//상하반전
	static void num1() {
		int[] temp=new int[M];
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M;j++) {
				temp[j]=map[i][j];
			}
			for(int j=0;j<M;j++) {
				map[i][j]=map[N-i-1][j];
			}
			for(int j=0;j<M;j++) {
				map[N-i-1][j]=temp[j];
			}
		}
	}
	//좌우반전
	static void num2() {
		int[] temp=new int[N];
		for(int j=0;j<M/2;j++) {
			for(int i=0;i<N;i++) {
				temp[i]=map[i][j];
			}
			for(int i=0;i<N;i++) {
				map[i][j]=map[i][M-j-1];
			}
			for(int i=0;i<N;i++) {
				map[i][M-j-1]=temp[i];
			}
		}
	}
	//
	static void num3() {
		int num=Math.max(N, M);
		num/=2;
		for(int t=0;t<num;t++) {
			int t1[]=new int[100];
			int t2[]=new int[100];
			int t3[]=new int[100];
			int t4[]=new int[100];
			
			int idx=0;
			for(int i=t;i<M-t;i++) {
				t2[idx++]=map[t][i];
			}
			idx=0;
			for(int i=t;i<N-t;i++) {
				t3[idx++]=map[i][M-t-1];
			}
			idx=0;
			for(int i=t;i<M-t;i++) {
				t4[idx++]=map[N-t-1][i];
			}
			idx=0;
			for(int i=t;i<N-t;i++) {
				t1[idx++]=map[i][t];
			}
			//새로운 배열에 삽입
			idx=0;
			for(int i=N-t-1;i>=t;i--) {
				newmap[t][i]=t1[idx++];
			}
			idx=0;
			for(int i=t;i<M-t;i++) {
				newmap[i][N-t-1]=t2[idx++];
			}
			idx=0;
			for(int i=N-t-1;i>=t;i--) {
				newmap[M-t-1][i]=t3[idx++];
			}
			idx=0;
			for(int i=t;i<M-t;i++) {
				newmap[i][t]=t4[idx++];
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++){
				map[i][j]=newmap[i][j];
			}
		}
	}
	static void num4() {
		int num=Math.max(N, M);
		
		num/=2;
		for(int t=0;t<num;t++) {
			int t1[]=new int[100];
			int t2[]=new int[100];
			int t3[]=new int[100];
			int t4[]=new int[100];
			
			int idx=0;
			for(int i=t;i<M-t;i++) {
				t4[idx++]=map[t][i];
			}
			idx=0;
			for(int i=t;i<N-t;i++) {
				t1[idx++]=map[i][M-t-1];
			}
			idx=0;
			for(int i=t;i<M-t;i++) {
				t2[idx++]=map[N-t-1][i];
			}
			idx=0;
			for(int i=t;i<N-t;i++) {
				t3[idx++]=map[i][t];
			}
			//새로운 배열에 삽입
			idx=0;
			for(int i=t;i<N-t;i++) {
				newmap[t][i]=t1[idx++];
			}
			idx=0;
			for(int i=M-t-1;i>=t;i--) {
				newmap[i][N-t-1]=t2[idx++];
			}
			idx=0;
			for(int i=t;i<N-t-1;i++) {
				newmap[M-t-1][i]=t3[idx++];
			}
			idx=0;
			for(int i=M-t-1;i>=t;i--) {
				newmap[i][t]=t4[idx++];
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++){
				map[i][j]=newmap[i][j];
			}
		}
	}
	static void num5() {
		int n=N/2;
		int m=M/2;
		int [][] t1=new int[n][m];
		int [][] t2=new int[n][m];
		int [][] t3=new int[n][m];
		int [][] t4=new int[n][m];
		//1번
		int i=0;
		int j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t2[x][y]=map[i+x][j+y];
			}
		}
		//2번
		i=0;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t3[x][y]=map[i+x][j+y];
			}
		}
		//4번
		i=N/2;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t1[x][y]=map[i+x][j+y];
			}
		}
		//3번저장
		i=N/2;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t4[x][y]=map[i+x][j+y];
			}
		}
		
		//다시 배열에 넣기
		//1번
		i=0;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t1[x][y];
			}
		}
		//2번
		i=0;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t2[x][y];
			}
		}
		//3번
		i=N/2;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t4[x][y];
			}
		}
		//4번저장
		i=N/2;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t3[x][y];
			}
		}		
		
	}
	static void num6() {
		int n=N/2;
		int m=M/2;
		int [][] t1=new int[n][m];
		int [][] t2=new int[n][m];
		int [][] t3=new int[n][m];
		int [][] t4=new int[n][m];
		//1번
		int i=0;
		int j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t4[x][y]=map[i+x][j+y];
			}
		}
		//2번
		i=0;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t1[x][y]=map[i+x][j+y];
			}
		}
		//4번
		i=N/2;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t3[x][y]=map[i+x][j+y];
			}
		}
		//3번저장
		i=N/2;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				t2[x][y]=map[i+x][j+y];
			}
		}
		
		//다시 배열에 넣기
		//1번
		i=0;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t1[x][y];
			}
		}
		//2번
		i=0;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t2[x][y];
			}
		}
		//3번
		i=N/2;
		j=0;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t4[x][y];
			}
		}
		//4번저장
		i=N/2;
		j=M/2;
		for(int x=0;x<N/2;x++) {
			for(int y=0;y<M/2;y++) {
				map[i+x][j+y]=t3[x][y];
			}
		}		
	}
	

}
