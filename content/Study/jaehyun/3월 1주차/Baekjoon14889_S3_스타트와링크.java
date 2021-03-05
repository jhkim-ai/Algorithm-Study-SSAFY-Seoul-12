package StepByStep.day210305;

import java.io.*;
import java.util.*;

// S3
public class Baekjoon14889_S3_스타트와링크 {

    static int N;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(N / 2, new boolean[N+1], 1);
        System.out.println(ans);
    }

    static void combination(int cnt, boolean[] selected, int startIdx) {
        if (cnt == 0) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for (int i = 1; i < selected.length; i++) {
                if(selected[i])
                    listA.add(i);
                else
                    listB.add(i);
            }
//            System.out.println(Arrays.toString(selected));
            int sumA = 0, sumB = 0;
            int aI = 0, aJ = 0;
            for (int i = 0; i < N/2 - 1; i++) {
                for (int j = i+1; j < N/2; j++) {
                    aI = listA.get(i);
                    aJ = listA.get(j);
                    sumA += map[aI][aJ] + map[aJ][aI];

                    aI = listB.get(i);
                    aJ = listB.get(j);
                    sumB += map[aI][aJ] + map[aJ][aI];
                }
            }
            ans = Math.min(ans, Math.abs(sumA-sumB));
            return;
        }

        for (int i = startIdx; i < N + 1; i++) {
            selected[i] = true;
            combination(cnt - 1, selected, i + 1);
            selected[i] = false;
        }
    }

    static String input = "6\n" +
            "0 1 2 3 4 5\n" +
            "1 0 2 3 4 5\n" +
            "1 2 0 3 4 5\n" +
            "1 2 3 0 4 5\n" +
            "1 2 3 4 0 5\n" +
            "1 2 3 4 5 0";
}
