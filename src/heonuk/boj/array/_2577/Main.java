package heonuk.boj.array._2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int multi(int x, int y, int z) {
        return x * y * z;
    }

    public static String solution(int A, int B, int C) {
        StringBuilder result = new StringBuilder();
        int[] arr = new int[10];

        int calc = multi(A, B, C);
        String strCalc = String.valueOf(calc);
        for (int i = 0; i < strCalc.length(); i++) {
            int idx = strCalc.charAt(i) - '0';
            arr[idx]++;
        }

        for (int i : arr) {
            result.append(i).append('\n');
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()); // 150
        int B = Integer.parseInt(br.readLine()); // 266
        int C = Integer.parseInt(br.readLine()); // 427
        System.out.println(solution(A, B, C));
    }

}
