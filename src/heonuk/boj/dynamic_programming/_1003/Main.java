package heonuk.boj.dynamic_programming._1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp = new int[41][2];

    static {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
    }

    public static void fillFibonacci() {
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }

    public static String solution(int T, int[] testCase) {
        StringBuilder result = new StringBuilder();
        fillFibonacci();
        for (int i = 0; i < T; i++) {
            int n = testCase[i];
            result.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int[] testCase = new int[T];
            for (int i = 0; i < T; i++) {
                testCase[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(solution(T, testCase));
        }
    }

}
