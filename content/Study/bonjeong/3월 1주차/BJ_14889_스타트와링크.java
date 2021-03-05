package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {
	static Integer[] answer;
	static boolean[] visited;
	static int N;
	static int[][] NArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		NArr = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				NArr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		

		// 조합으로 팀 N/2개 고른다. 
		answer = new Integer[N/2];
		visited = new boolean[N];
		comb(0, 0);
		
		System.out.println(min);
		
	}
	
	static int min = 100;
	static void comb(int cnt, int start) {
		if(cnt == N/2) {

			// 스타트팀 번호: startList
			ArrayList<Integer> startList = new ArrayList<>(Arrays.asList(answer)); //스타트팀의 능력치 저장 리스트

			// 링크팀 번호 list: linkList
			List<Integer> linkList = new ArrayList<>();
			for(int i= 0; i < N; i++) {
				if(startList.contains(i)) // answer array 중 스타트팀에 없는 번호 추가
					continue;
				else
					linkList.add(i);
			}
			
			func(startList, linkList);
//			System.out.println(startList);
//			System.out.println(linkList);
			return;
		}
		
		for(int i = start; i < N; i++) {
			answer[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	static void func(ArrayList<Integer> startList, List<Integer> linkList) {
		// 스타트팀 능력치 합 (for문 이용한 조합)
		int sum1 = 0;
		for(int i= 0;i < startList.size(); i++) {
			for(int j = i+1; j < startList.size(); j++) {
				sum1 += NArr[startList.get(i)][startList.get(j)];
				sum1 += NArr[startList.get(j)][startList.get(i)];
			}
		}
		
		//링크팀 능력치 합 (for문 이용한 조합)
		int sum2 = 0;
		for(int i= 0;i < linkList.size(); i++) {
			for(int j = i+1; j < linkList.size(); j++) {
				sum2 += NArr[linkList.get(i)][linkList.get(j)];
				sum2 += NArr[linkList.get(j)][linkList.get(i)];
			}
		}
		
//		System.out.println(sum1);
//		System.out.println(sum2);
		
		min = Math.min(min,Math.abs(sum1-sum2));
	}
}
