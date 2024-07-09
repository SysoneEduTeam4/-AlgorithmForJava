package heonuk.boj.hash._9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int solution(int n, String[] items) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : items) {
            String[] data = item.split(" ");
            if (map.containsKey(data[1])) {
                map.put(data[1], map.get(data[1]) + 1);
            } else { // 새로운 종류
                map.put(data[1], 1);
            }
        }

        int result = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result = result * (entry.getValue() + 1);
        }
        return result - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] items = new String[n];
            for (int j = 0; j < n; j++) {
                items[j] = br.readLine();
            }
            result.append(solution(n, items)).append("\n");
        }
        System.out.println(result);
    }
}
