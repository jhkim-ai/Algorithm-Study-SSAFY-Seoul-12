package StepByStep.day210305;

import java.io.*;
import java.util.*;

public class Baekjoon1931_S2_회의실배정 {

    static int N;
    static Point[] arr;

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // -------- 알고리즘 시작 -------- //

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.end == o2.end)
                    return Long.compare(o1.start, o2.start);
                else
                    return Long.compare(o1.end, o2.end);
            }
        });

        int ans = 1;
        long end = arr[0].end;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].start >= end) {
                end = arr[i].end;
                ans++;
            }
        }

        System.out.println(ans);
    }

    static class Point{
        long start;
        long end;

        public Point(long y, long x) {
            this.start = y * 1l;
            this.end = x * 1l;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static String input = "5\n" +
            "4 5\n" +
            "4 4\n" +
            "3 4\n" +
            "2 5\n" +
            "1 3";
}
