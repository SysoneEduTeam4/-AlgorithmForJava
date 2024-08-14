package heonuk.boj.sort_and_search._5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long[] solution(int n, String[] strNum) {
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(strNum[i]).reverse().toString();
            result[i] = Long.parseLong(rev);
        }

        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] strNum = new String[n];
        int idx = 0;

        while (st.hasMoreTokens() && idx < n) {
            strNum[idx++] = st.nextToken();
        }

        while (idx < n) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && idx < n) {
                strNum[idx++] = st.nextToken();
            }
        }

        for (long num : solution(n, strNum)) {
            System.out.println(num);
        }
    }

}
