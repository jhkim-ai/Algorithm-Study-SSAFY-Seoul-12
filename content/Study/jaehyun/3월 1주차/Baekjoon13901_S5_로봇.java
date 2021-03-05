package StepByStep.day210305;

import java.io.*;
import java.util.*;

public class Baekjoon13901_S5_로봇 {

    static int Y, X, K;
    static char[][] map;
    static Point robot;
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] order = new int[4];

    public static void main(String[] args) throws Exception {

        // ----------- 데이터 입력 ----------- //

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new char[Y][X];

        for (int y = 0; y < Y; y++) {
            Arrays.fill(map[y], '*');
        }
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 'x';
        }

        st = new StringTokenizer(br.readLine());
        robot = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        map[robot.y][robot.x] = '0';

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        // ----------- 알고리즘 시작 ----------- //

        while(true) {
            // 지정한 방향 순으로 반복
            for (int i = 0; i < 4; i++) {
                int d = order[i];

                // 1번째 제약 : 지정한 방향으로 일직선으로 움직인다.
                while (true) {
                    
                    // 새로운 좌표
                    int ny = robot.y + dy[d];
                    int nx = robot.x + dx[d];
                    
                    // 벽 or 방문 지역 or 장애물을 만날 경우 Check
                    if (isIn(ny, nx) && map[ny][nx] == '*') {
                        map[ny][nx] = (char) (map[robot.y][robot.x] + 1);
                        robot.y = ny;
                        robot.x = nx;
                    } 
                    // 2번째 제약 : 벽 or 방문 지역 or 장애물을 만날 경우 다음 방향으로 이동
                    else
                        break;
                }
            }

            // 3번째 제약 : 다음방향이 없다면, 맨 처음 방향으로 돌아간다.
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int d = order[i];
                int ny = robot.y + dy[d];
                int nx = robot.x + dx[d];

                // 다음 방향으로 갈 수 없는 경우를 Check
                if( !isIn(ny,nx) || map[ny][nx] != '*')
                    cnt++;
            }

            // 4번째 제약 : Robot이 움직일 수 없다면 (cnt = 4), 동작을 멈춘다
            //                    움직일 수 있다면 (cnt != 4), 다시 동작
            if(cnt == 4)
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(robot.y).append(" ").append(robot.x);
        System.out.println(sb);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < Y && 0 <= x && x < X;
    }

    static String input = "3 3\n" +
            "1\n" +
            "1 0\n" +
            "1 1\n" +
            "1 2 3 4";
}
