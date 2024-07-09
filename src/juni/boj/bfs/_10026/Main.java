package juni.boj.bfs._10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] dx = {0,0,-1,1};
    private static final int[] dy = {-1,1,0,0};
    private static char[][] fields;
    private static boolean[][] visited;

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
        n = Integer.parseInt(br.readLine());
        fields = new char[n][n];

        for(int i=0;i<n;i++){
            fields[i] = br.readLine().toCharArray();
        }

        int resultNormal = 0;
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (!visited[i][j]){
                    resultNormal++;
                    BFS_Normal(j,i);
                }
            }
        }

        int resultSakmang = 0;
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (!visited[i][j]){
                    resultSakmang++;
                    BFS_SakMang(j,i);
                }
            }
        }

        System.out.println(resultNormal+" "+resultSakmang);
    }

    private static void BFS_Normal(int x, int y) {
        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(x,y));
        visited[y][x] = true;
        while(!que.isEmpty()){
            Position po = que.poll();

            for(int i=0;i<4;i++){
                int nx = po.x +dx[i];
                int ny = po.y +dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) { // 경계 조건 확인
                    if (!visited[ny][nx] && fields[po.y][po.x] == fields[ny][nx]) {
                        que.offer(new Position(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

    }

    private static void BFS_SakMang(int x, int y) {
        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(x,y));
        visited[y][x] = true;
        while(!que.isEmpty()) {
            Position po = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = po.x + dx[i];
                int ny = po.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) { // 경계 조건 확인
                    boolean similar = (fields[po.y][po.x] =='R' && fields[ny][nx] =='G' )|| (fields[po.y][po.x] =='G' && fields[ny][nx] =='R');
                    if (!visited[ny][nx] && (fields[po.y][po.x] == fields[ny][nx]|| similar)) {
                       que.offer(new Position(nx, ny));
                            visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
