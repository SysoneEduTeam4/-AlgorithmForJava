package bakejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine());
		String[] array;
		
		for (int i = 0 ; i < L; i++) {
			Stack<String> left = new Stack<>();
			Stack<String> right = new Stack<>();
			
			array = br.readLine().split("");
			//push() : 데이터를 스택에 추가하고, 해당 값을 반환
			//pop() : 스택의 마지막 요소 제거함과 동시에 해당 값을 반환
			for(String str : array) {
				switch (str) {
					case "<" :
						if (!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case ">" :
						if (!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case "-" :
						if (!left.isEmpty()) {
							left.pop();
						}
						break;
					default :
						left.push(str);
				}
			}
			
			while (!left.isEmpty()) {
				right.push(left.pop());
			}
			while (!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
