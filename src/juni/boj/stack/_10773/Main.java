package juni.boj.stack._10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number!=0){
                int plusNumber = stack.push(number);
                result+= plusNumber;
            }else{
                int minusNumber = stack.pop();
                result-= minusNumber;
            }
        }
        System.out.println(result);
    }
}
