package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] NArr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 끝나는 시간순으로 정렬. 끝나는 시간 같으면 시작시간 빠른걸로 정렬 (시작하자마자 바로 끝나는 회의 고려)
		Arrays.sort(NArr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		
		
		/*
 			2
			2 2
			1 2
		 */
		
		// 탐색
		int end = NArr[0][1]; // 최솟값 저장.
		int answ = 1;
		
		for(int n = 1; n < N; n++) {
			if(NArr[n][0] >= end) { // 끝나는 시간이 더 늦은거 나오면
				answ++; // 가능 회의 수 증가시키고
				end = NArr[n][1]; // 업데이트
			}
		}
		
		System.out.println(answ);
	}
}
