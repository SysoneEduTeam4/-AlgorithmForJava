package heonuk.boj.bfs._7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int M, N, H;
    static int[][][] tomatoStorage;
    static int[] dm = {0, -1, 0, 1, 0, 0};
    static int[] dn = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    /**
     * 익은 토마토 위치를 초기화하기 위한 메서드
     * 1: 익은 토마토
     * 0: 익지 않은 토마토
     * -1: 토마토 없음
     */
    public static Queue<int[]> initTomato() {
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoStorage[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }
        return queue;
    }

    public static int bfs() {
        Queue<int[]> tomatoInfo = initTomato(); // 익은 토마토를 큐에 초기화
        int days = 0;

        while (!tomatoInfo.isEmpty()) {
            int size = tomatoInfo.size();
            for (int i = 0; i < size; i++) {
                int[] tomato = tomatoInfo.poll();
                int h = tomato[0];
                int n = tomato[1];
                int m = tomato[2];

                for (int dirt = 0; dirt < 6; dirt++) {
                    int curH = h + dh[dirt];
                    int curN = n + dn[dirt];
                    int curM = m + dm[dirt];

                    if (curH >= 0 && curN >= 0 && curM >= 0 && curH < H && curN < N && curM < M) {
                        if (tomatoStorage[curH][curN][curM] == 0) {
                            tomatoInfo.add(new int[]{curH, curN, curM});
                            tomatoStorage[curH][curN][curM] = 1;
                        }
                    }
                }
            }
            days++;
        }
        return days;
    }

    /**
     * 토마토가 모두 익었는지 확인하는 메서드
     * @return true: 0 이 없으면 모두 익음
     *         false: 0 이 있으면 익지 않은 토마토가 있음
     */
    static boolean isAllRipe() { //
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoStorage[h][n][m] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int solution() {
        int days = bfs();
        if (isAllRipe()) days -= 1;
        else days = -1;
        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boxInfo = br.readLine().split(" ");
        M = Integer.parseInt(boxInfo[0]); // 가로
        N = Integer.parseInt(boxInfo[1]); // 세로
        H = Integer.parseInt(boxInfo[2]); // 높이

        tomatoStorage = new int[H][N][M]; // 높이, 세로, 가로

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] tomatoInfo = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    tomatoStorage[h][n][m] = Integer.parseInt(tomatoInfo[m]);
                }
            }
        }
        System.out.println(solution());
    }
}
