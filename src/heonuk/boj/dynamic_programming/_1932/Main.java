package heonuk.boj.dynamic_programming._1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int solution(int n, int[][] arr) {
        int[][] dp = new int[n][n];
        System.arraycopy(arr[n - 1], 0, dp[n - 1], 0, n);

        for (int depth = n - 2; depth >= 0 ; depth--) {
            for (int valueIdx = 0; valueIdx <= depth; valueIdx++) {
                dp[depth][valueIdx] = Math.max(
                        dp[depth + 1][valueIdx], dp[depth + 1][valueIdx + 1]
                ) + arr[depth][valueIdx];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            System.out.println(solution(n, arr));
        }
    }

}
