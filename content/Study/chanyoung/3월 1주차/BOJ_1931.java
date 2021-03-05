// 1931, 회의실 배정 | https://www.acmicpc.net/problem/1931
// 48,240KB | 600ms
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1931 {

	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		List<Integer[]> meetings = new ArrayList<Integer[]>(); // 회의 시간(Integer[]) 저장하는 List
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			meetings.add(new Integer[] { start, end });
		}
		// 입력 끝

		/*
		 * // 입력 확인 for (int i=0;i<meetings.size();i++) {
		 * System.out.println(Arrays.toString(meetings.get(i))); }
		 */

		// 끝나는 시간이 먼저인 순으로 오름차순 정렬한다.
		Collections.sort(meetings, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});

		/*
		 * // 정렬 확인 for (int i=0;i<meetings.size();i++) {
		 * System.out.println(Arrays.toString(meetings.get(i))); }
		 */

		int meetingCnt = 0; // 회의 개수
		int end = 0;
		for (int i = 0; i < meetings.size(); i++) {
			// 회의의 시작 시간이 현재 미팅의 끝나는 시간보다 나중이면 회의 시작 가능
			// 회의 개수 1 증가, end 값 update
			if (meetings.get(i)[0] >= end) {
				meetingCnt++;
				end = meetings.get(i)[1];
			}
		}
		
		System.out.println(meetingCnt);
	}

}
