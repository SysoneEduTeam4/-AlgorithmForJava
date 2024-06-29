package heonuk.boj.stack_queue_deque._3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static int solution(int n, String[] words) {
        int result = 0;
        for (String word : words) {
            if (isGood(word)) {
                result++;
            }
        }
        return result;
    }

    public static boolean isGood(String word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        System.out.println(solution(n, words));
    }

}