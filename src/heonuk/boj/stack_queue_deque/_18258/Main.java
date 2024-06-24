package heonuk.boj.stack_queue_deque._18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    private static String solution(int n, String[] orders, int[] numbers) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            switch (orders[i]) {
                case "push":
                    queue.add(numbers[i]);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        result.append(queue.removeFirst()).append("\n");
                    } else {
                        result.append(-1).append("\n");
                    }
                    break;
                case "size":
                    result.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (!queue.isEmpty()) {
                        result.append(0).append("\n");
                    } else {
                        result.append(1).append("\n");
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        result.append(queue.peekFirst()).append("\n");
                    } else {
                        result.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        result.append(queue.peekLast()).append("\n");
                    } else {
                        result.append(-1).append("\n");
                    }
                    break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] orders = new String[n];
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            orders[i] = input[0];
            if (input[0].equals("push")) {
                numbers[i] = Integer.parseInt(input[1]);
            }
        }

        System.out.println(solution(n, orders, numbers));
    }

}
