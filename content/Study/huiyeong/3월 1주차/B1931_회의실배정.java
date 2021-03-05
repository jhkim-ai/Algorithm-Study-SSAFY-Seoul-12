package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1931_회의실배정 {
	public static class meet implements Comparable<meet>{
		int start, end;

		public meet(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return start + " " + end;
		}

		@Override
		public int compareTo(meet o) {
			int diff = this.end-o.end;
			return diff!=0?diff:this.start-o.start;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		meet[] room = new meet[N];
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			room[i] = new meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(room);
		List<meet> list = new ArrayList<>();
		list.add(room[0]);
		for (int i=1;i<N;i++) {
			if (list.get(list.size()-1).end<=room[i].start) {
				list.add(room[i]);
			}
		}
		System.out.println(list.size());
	}
}
