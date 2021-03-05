package com.BaekJoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_회의실_배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static team [] able; //열리는 총 회의
	static team [] visited; //결국 최종으로 열릴 수 있는 회의만 담는 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine()); //회의 갯수 - 읽어 들일 줄을 의미하기도 함
		able = new team[N];
		visited = new team[N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
				able[i] = new team(s, e);

		}
//		if(able == null) {
//			System.out.println("0");
//			System.exit(0);
//		}
		
		
		Arrays.sort(able); //총 회의를 끝나는 시간 기준으로 정렬
		System.out.println(Arrays.toString(able)); //정렬 확인하기 위한 문장 나중에 지워야해요~~
		
		 int count = 1; // 회의는 무조건 시작하고 시작하므로 1부터 시작한다.
		
		int min = able[0].getEnd(); // 끝나는 시간을 담은 min
		//for문을 돌면서 다음 회의의 시작값이 현재 배정된 회의의 끝나는 시간보다 크거나 같으면 열릴 수 있다.
		for(int i = 1; i< N; i++) {
			if(min <= able[i].getStart()) {
				visited[i] = able[i]; // 배정 회의로 넣는다.
				min = able[i].getEnd(); // 끝나는 시간 갱신
				count++; // 배정되었으므로 카운트 세어준다.
			}
		}
//		for(int i = 0; i< N; i++) {
//			if(visited[i] != null) {
//				count++;
//			}
//		}
		
		System.out.println(count);
		//System.out.println(Arrays.toString(visited));
	}
	
	//team 클래스를 생성하여 첫시작과 끝나는 시간을 담아준다. 비교 가능하게 implements해준다
	static class team implements Comparable<team>{
		int start;
		int end;


		public int getStart() {
			return start;
		}


		public void setStart(int start) {
			this.start = start;
		}


		public int getEnd() {
			return end;
		}


		public void setEnd(int end) {
			this.end = end;
		}


		@Override
		public String toString() {
			return "team [start=" + start + ", end=" + end + "]";
		}


		public team(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
//아래 예시 처럼 끝나는 시간이 같을 경우를 대비해 
		//끝나는 시간이 같으면 시작값을 비교해 더 작은 값을 앞으로 정렬시키도록 한다.

		@Override
		public int compareTo(team o) {
			if(this.end ==o.end) {
				return this.start-o.start;
			}
			return this.end - o.end;
		}
		
		
	}
	static String src="2\r\n" + 
			"2 2\r\n" + 
			"1 2";
}
