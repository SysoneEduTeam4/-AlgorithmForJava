package hyukkyu.boj.stackandqueue._10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int K = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			K = Integer.parseInt(br.readLine());
			
			if (K != 0) {	//0이 아니면 스택에 삽입
				stack.push(K);
			} else {	//0이면 스텍에서 삭제
				stack.pop();
			}
		}
		
		int sum = 0;
		for(int i : stack) {
			sum += i;
		}
		System.out.println(sum);
	}
}
