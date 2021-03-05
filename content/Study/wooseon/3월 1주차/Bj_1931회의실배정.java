package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_1931회의실배정 {

	static int n;
	static int[][] time;
	static int m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		time = new int[n][2];
		isSelected=new boolean[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
			m=Math.max(max, time[i][1]);
		}
		visited=new boolean[m+1];
		
		Arrays.sort(time, new Comparator<>() {
			
		});
		
		powerset(0);
		System.out.println(max);
		
	}
	
	static boolean visited[];
	static boolean isSelected[];
	static int max=0;
	
	static void powerset(int cnt) {
		if(cnt==n) {
			for(int i=0;i<=m;i++) {
				visited[i]=false;
			}
			
			int c=0;
			for(int i=0;i<n;i++) {
				if(isSelected[i]==true) {
					c++;
					int a=time[i][0];
					int b=time[i][1];
					for(int j=a;j<=b;j++) {
						if(!visited[j])
							visited[j]=true;
						else {
							c=0;
							break;
						}
					}
					
				}
			}
			
			max=Math.max(max, c);
			return;
		}
		
		isSelected[cnt]=true;
		powerset(cnt+1);
		isSelected[cnt]=false;
		powerset(cnt+1);
	}

}
