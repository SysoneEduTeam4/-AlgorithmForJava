package heonuk.boj.stack_queue_deque._10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int number : arr) {
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        for (Integer number : stack) {
            sum += number;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(arr));
    }

}
