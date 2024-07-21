package juni.boj.dfs._1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] papers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        papers = new int[n][n];
        for(int i=0;i<n;i++){
            String[] line = br.readLine().split("");
            for(int j=0;j<n;j++){
                papers[i][j] = Integer.parseInt(line[j]);
            }
        }
        recursive(0,0,n);
        System.out.println(sb);
    }
    public static void recursive(int x,int y, int length){
        if(check(x,y,length)){
            if(papers[x][y]==0){
                sb.append(0);
            }else {
                sb.append(1);
            }
            return;
        }

        int size = length/2;
        sb.append("(");
        recursive(x,y,size);
        recursive(x,y+size,size);
        recursive(x+size,y,size);
        recursive(x+size,y+size,size);
        sb.append(")");
    }
    public static boolean check(int x,int y,int length){
        for(int i=x;i<x+length;i++){
            for(int j=y;j<y+length;j++){
                if(papers[x][y]!=papers[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
