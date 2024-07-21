package juni.boj.dfs._15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int n;
    private static int m;

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        numbers = new int[n];
        visited = new boolean[10];
        inputs = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);
        arr = new int[m];
        backTracking(0,0);
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

        for(int i=start;i<n;i++){
            arr[count] = numbers[i];
            backTracking(i,count+1);
        }

    }
}

