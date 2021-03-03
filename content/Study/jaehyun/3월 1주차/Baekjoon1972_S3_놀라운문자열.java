package StepByStep.day210305;

import java.io.*;
import java.util.*;

public class Baekjoon1972_S3_놀라운문자열 {

    static String str;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; ; t++) {
            str = br.readLine();
            if (str.equals("*")) break;
            int len = str.length();

            int l = 1;
            boolean flag = false;
            all:
            while (l < len) {
                Set<String> s = new HashSet<>();
                for (int i = 0; i < str.length() - 1; i++) {
                    if (i + l + 1 > len)
                        continue;
                    char[] arr = {str.charAt(i), str.charAt(i+l)};
                    String tmp = String.valueOf(arr);

                    if (!s.contains(tmp))
                        s.add(tmp);
                    else {
                        flag = true;
                        break all;
                    }
                }
                l++;
            }

            if (!flag)
                sb.append(str).append(" is surprising.\n");
            else {
                sb.append(str).append(" is NOT surprising.\n");
            }
        }
        System.out.println(sb);
    }

    static String input = "ZGBG\n" +
            "X\n" +
            "EE\n" +
            "AAB\n" +
            "AABA\n" +
            "AABB\n" +
            "BCBABCC\n" +
            "*";
}
