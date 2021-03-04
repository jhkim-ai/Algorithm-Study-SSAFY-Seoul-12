// https://www.acmicpc.net/problem/1931
// 회의실 배정
// Greedy, Sort
package boj;

import java.io.*;
import java.util.*;

// Comparator 인터페이스를 이용한 정렬
// Comparator 인터페이스의 구현체를 Arrays.sort()나 Collections.sort()와 같은 정렬 메서드에 추가 인자로 넘기면
// 정렬 기준이 누락된 클래스의 캑체나 기존 정렬 기준을 무시하고 새로운 정렬 기준으로 객체를 정렬할 수 있다.
public class BOJ_1931 {
	public static class Time{
		int start;
		int end;
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Time[] arr = new Time[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = (new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}		
		
		Comparator<Time> comp = new Comparator<Time>() {
			@Override
			public int compare(Time a, Time b) {
				if(a.end == b.end) return a.start - b.start;
				else return a.end - b.end;
			}
		};
		
		Arrays.sort(arr, comp);
		
		int endtime = arr[0].end;
		int ans = 1;
		for(int i = 1; i<N; ++i) {
			if(arr[i].start >= endtime) {
				endtime = arr[i].end;
				++ans;
			}
		}
		System.out.print(ans);
	}
}


/*  람다로 구현한 정렬
public class BOJ_1931 {
	public static class Time{
		int start;
		int end;
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Time[] arr = new Time[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = (new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Arrays.sort(arr, (a, b) -> {
			if(a.end == b.end) {
				return a.start - b.start;
			}
			else
				return a.end - b.end;
		});
		
		int endtime = arr[0].end;
		int ans = 1;
		for(int i = 1; i<N; ++i) {
			if(arr[i].start >= endtime) {
				endtime = arr[i].end;
				++ans;
			}
		}
		System.out.print(ans);
	}
}
 */


/*  일반 배열에 comparable 인터페이스를 구현하여 정렬
public class BOJ_1931 {
	public static class Time implements Comparable<Time>{
		int start;
		int end;
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time t) {
			if(end == t.end) {
				return start - t.start;
			}
			else
				return end-t.end;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Time[] arr = new Time[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = (new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Arrays.sort(arr);
		
		int endtime = arr[0].end;
		int ans = 1;
		for(int i = 1; i<N; ++i) {
			if(arr[i].start >= endtime) {
				endtime = arr[i].end;
				++ans;
			}
		}
		System.out.print(ans);
	}
}
*/
