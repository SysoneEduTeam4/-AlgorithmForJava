package boj.stack_queue_deque._3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] array = new String[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine();
		}
		
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			Stack<Character> stack = new Stack<Character>();
			String str = array[i];
			
			for(int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if(stack.size() > 0 && stack.peek().equals(ch)) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
			if(stack.size() == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
