package StepByStep.day210305;

import java.io.*;
import java.util.*;

public class Baekjoon3048_S4_개미 {

    static int N1, N2, T;
    static Ant[] arr;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        arr = new Ant[N1 + N2];

        char[] tmp = br.readLine().toCharArray();
        char[] tmp2 = br.readLine().toCharArray();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N1 + N2; i++) {
            if (i < N1) {
                arr[i] = new Ant(tmp[N1 - 1 - i], 1);
            } else {
                arr[i] = new Ant(tmp2[i - N1], -1);
            }
        }

        int cnt = 0;
        while (cnt != T) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].d == 1 && arr[i + 1].d == -1) {
                    Ant t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    i++;
                }
            }
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for(Ant a : arr)
            sb.append(a.word);
        System.out.println(sb);
    }

    static class Ant {
        char word;
        int d;

        public Ant(char word, int d) {
            this.word = word;
            this.d = d;
        }

        @Override
        public String toString() {
            return word + ", ";
        }
    }

    static String input = "3 4\n" +
            "JLA\n" +
            "CRUO\n" +
            "7";
}
