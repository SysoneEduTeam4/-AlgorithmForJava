package heonuk.boj.stack_queue_deque._1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static int solution(int n, int m, int[] data) {
        int result = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        for (int i = 0; i < m; i++) {
            int target = data[i]; // 현재 회전 연산의 목표 값
            int count = 0; // 회전 횟수를 초기화

            while (deque.peek() != null && target != deque.peek()) {
                deque.add(deque.poll());
                count++;
            }

            result += Math.min(count, deque.size() - count);
            deque.poll();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]); // 큐의 크기
        int m = Integer.parseInt(line1[1]); // 뽑아 내려고 하는 수의 개수
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(n, m, data));
    }

}