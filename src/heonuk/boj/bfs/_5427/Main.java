package heonuk.boj.bfs._5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    /**
     * 불 확산 처리 메서드
     */
    static void spreadFire(Queue<int[]> fire, char[][] map, int W, int H) {
        int fireSize = fire.size();
        // 현재 불의 위치를 기준
        for (int i = 0; i < fireSize; i++) {
            int[] firePos = fire.poll();
            int fireX = firePos[0];
            int fireY = firePos[1];

            // 4방향 확산 처리
            for (int d = 0; d < 4; d++) {
                int nextFireX = fireX + dx[d];
                int nextFireY = fireY + dy[d];

                if (nextFireX >= 0 && nextFireY >= 0 && nextFireX < H && nextFireY < W) {
                    // 빈 칸으로 불이 옮겨 갈 수 있음
                    if (map[nextFireX][nextFireY] == '.') {
                        map[nextFireX][nextFireY] = '*';
                        fire.add(new int[]{nextFireX, nextFireY});
                    }
                }
            }
        }
    }

    /**
     * 상근이 이동 처리 메서드
     */
    static String movePlayer(Queue<int[]> queue, char[][] map, int W, int H) {
        int queueSize = queue.size();
        // 현재 위치 기준
        for (int i = 0; i < queueSize; i++) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int time = pos[2];

            // 탈출 조건: 상근이가 가장자리로 이동하게 되면 탈출
            if (x == 0 || x == H - 1 || y == 0 || y == W - 1) {
                return String.valueOf(time + 1);
            }

            for (int d = 0; d < 4; d++) {
                int nextX = x + dx[d];
                int nextY = y + dy[d];

                if (nextX >= 0 && nextY >= 0 && nextX < H && nextY < W) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == '.') {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, time + 1});
                    }
                }
            }
        }
        return null;
    }

    static String bfs(int userX, int userY, Queue<int[]> fire, char[][] map, int W, int H) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{userX, userY, 0});
        visited[userX][userY] = true;

        while (!queue.isEmpty()) {
            spreadFire(fire, map, W, H);
            String result = movePlayer(queue, map, W, H);
            if (result != null) {
                return result;
            }
        }

        return "IMPOSSIBLE";
    }

    public static String solution(int W, int H, char[][] map) {
        int startX = 0, startY = 0;
        visited = new boolean[H][W];
        Queue<int[]> fire = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (map[h][w] == '@') {
                    startX = h;
                    startY = w;
                } else if (map[h][w] == '*') {
                    fire.add(new int[]{h, w});
                }
            }
        }

        return bfs(startX, startY, fire, map, W, H);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            String[] wh = br.readLine().split(" ");
            int W = Integer.parseInt(wh[0]);
            int H = Integer.parseInt(wh[1]);

            char[][] map = new char[H][W];
            for (int h = 0; h < H; h++) {
                map[h] = br.readLine().toCharArray();
            }
            result.append(solution(W, H, map)).append("\n");
        }
        System.out.println(result);
    }
}
