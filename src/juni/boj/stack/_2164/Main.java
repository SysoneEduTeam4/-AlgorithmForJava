package juni.boj.stack._2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = Solution(n);
        System.out.println(result);
    }

    private static int Solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        int result = q.poll();
        return result;
    }
}

