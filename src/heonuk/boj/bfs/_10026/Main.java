package heonuk.boj.bfs._10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    static int cntR, cntG, cntB, cntRG;

    public static void bfs(int col, int row, char color1, char color2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            visited[x][y] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int curX = dx[i] + x;
                int curY = dy[i] + y;

                if (curX >= 0 && curY >= 0 && curX < grid.length && curY < grid.length) {
                    if ((grid[curX][curY] == color1 || grid[curX][curY] == color2)
                            && !visited[curX][curY]) {
                        queue.add(new int[]{curX, curY});
                        visited[curX][curY] = true;
                    }
                }
            }

        }
    }

    public static String solution(int N) {
        StringBuilder result = new StringBuilder();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R' && !visited[i][j]) {
                    bfs(i, j, 'R', 'R');
                    cntR++;
                    continue;
                }

                if (grid[i][j] == 'G' && !visited[i][j]) {
                    bfs(i, j, 'G', 'G');
                    cntG++;
                    continue;
                }

                if (grid[i][j] == 'B' && !visited[i][j]) {
                    bfs(i, j, 'B', 'B');
                    cntB++;
                    continue;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((grid[i][j] == 'R' || grid[i][j] == 'G') && !visited[i][j]) {
                    bfs(i, j, 'R', 'G');
                    cntRG++;
                }
            }
        }
        result.append(cntR + cntG + cntB).append(' ').append(cntRG + cntB);
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        System.out.println(solution(N));
    }

}
