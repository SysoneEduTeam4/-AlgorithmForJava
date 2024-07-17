package heonuk.boj.bfs._7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] chess;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2},
                 dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 8; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];

                if (curX >= 0 && curY >= 0 && curX < chess.length && curY < chess.length) {
                    if (!visited[curX][curY]) {
                        queue.add(new int[]{curX, curY});
                        chess[curX][curY] = chess[x][y] + 1;
                        visited[curX][curY] = true;
                    }
                }
            }
        }
    }

    public static int solution(int I, int startX, int startY, int targetX, int targetY) {
        chess = new int[I][I];
        visited = new boolean[I][I];
        bfs(startX, startY);
        return chess[targetX][targetY];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int I = Integer.parseInt(br.readLine());

            String[] startXY = br.readLine().split(" ");
            int startX = Integer.parseInt(startXY[0]);
            int startY = Integer.parseInt(startXY[1]);

            String[] targetXY = br.readLine().split(" ");
            int targetX = Integer.parseInt(targetXY[0]);
            int targetY = Integer.parseInt(targetXY[1]);

            result.append(solution(I, startX, startY, targetX, targetY)).append("\n");
        }
        System.out.println(result);
    }

}
