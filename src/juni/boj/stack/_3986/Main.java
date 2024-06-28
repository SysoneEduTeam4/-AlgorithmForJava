package juni.boj.stack._3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i]=br.readLine();
        }
        int result = Solution(words);
        System.out.println(result);
    }

    private static int Solution(String[] words) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        for(String word : words){
            stack.clear();
            String[] ws = word.split("");
            stack.push(ws[0]);
            for(int i=1;i<ws.length;i++){
                if(stack.size()==0){
                    stack.push(ws[i]);
                    continue;
                }
                if(stack.peek().equals(ws[i])){
                    stack.pop();
                }else stack.push(ws[i]);
            }
            if(stack.size()==0){
                System.out.println("++");
                count++;
            }
        }
        return count;
    }
}
