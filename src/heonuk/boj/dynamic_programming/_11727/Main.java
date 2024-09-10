package heonuk.boj.dynamic_programming._11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp = new int[1001];
    static {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
    }

    private static int solution(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solution(n));
        }
    }

}
