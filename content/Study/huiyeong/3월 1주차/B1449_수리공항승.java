package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1449_수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] water = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water);
		int fixF = 0, fixL = 0, cnt = 0;
		for (int i=0;i<N;i++) {
			if (fixF>=water[i] || water[i]>=fixL) { // 위치가 테이프 길이를 벗어날 때
				cnt++;
				fixF = water[i];
				fixL = water[i]+L;  
			}
		}
		System.out.println(cnt);
	}
}
