package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3048_개미 {
	static class ant {
		char data;
		int dir;

		public ant(char data, int dir) {
			super();
			this.data = data;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		int size = N1+N2;
		List<ant> list = new ArrayList<>();
		String word1 = br.readLine();
		for (int i=N1-1;i>=0;i--) {
			list.add(new ant(word1.charAt(i), 0));
		}
		String word2 = br.readLine();
		for (int i=0;i<N2;i++) {
			list.add(new ant(word2.charAt(i), 1));
		}
		int T = Integer.parseInt(br.readLine());
		// 입력완료
		
		for (int t=0;t<T;t++) {
			for (int i=0;i<size-1;i++) {
				if (list.get(i).dir==0 && list.get(i).dir!=list.get(i+1).dir) { // 다음 개미가 나랑 방향 다르면 바꿔줌
					char data = list.get(i).data;
					int dir = list.get(i).dir;
					list.get(i).data = list.get(i+1).data;
					list.get(i).dir = list.get(i+1).dir;
					list.get(i+1).data = data;
					list.get(i+1).dir = dir;
					i++;
				} 
			}
		}
		for (int i=0;i<list.size();i++) {
			sb.append(list.get(i).data);
		}
		System.out.println(sb);
	}
}
