package juni.boj.dfs._15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int m;

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        arr = new int[m];
        backTracking(1,0);
        System.out.println(sb);
    }

    private static void backTracking(int start, int count) {
        if(count==m){
            for(int a:arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            arr[count] = i;
            backTracking(i+1,count+1);
        }

    }
}
