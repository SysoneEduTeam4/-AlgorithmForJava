package juni.boj.bfs._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};
    private static int fields[][];
    private static boolean visited[][];
    private static int m;
    private static int n;

    public static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        for(int t=0;t<test_case;t++){
            String[] inputs = br.readLine().split(" ");
            m = Integer.parseInt(inputs[0]); // 가로
            n = Integer.parseInt(inputs[1]); // 세로
            int k = Integer.parseInt(inputs[2]); // 배추위치
            fields = new int[n][m];
            visited = new boolean[n][m];
            for(int i=0;i<k;i++){
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                fields[y][x] = 1;
            }
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j] == false && fields[i][j] == 1){
                        count++;
                        BFS(j,i);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(x,y));
        visited[y][x] = true;
        while(!que.isEmpty()){
            Position po = que.poll();

            for(int i=0;i<4;i++){
                int nx = po.x +dx[i];
                int ny = po.y +dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) { // 경계 조건 확인
                    if (!visited[ny][nx] && fields[ny][nx] == 1) { // 방문 여부 및 배추 위치 확인
                        que.offer(new Position(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
