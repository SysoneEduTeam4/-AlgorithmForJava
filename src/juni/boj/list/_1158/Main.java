package juni.boj.list._1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }

        System.out.print("<");
        while(!q.isEmpty()){
            if(q.size()==1){
                System.out.print(q.poll());
            }else {
                for(int i=0;i<k-1;i++){
                    q.offer(q.poll());
                }
                int a = q.poll();
                System.out.print(a+", ");
            }
        }
        System.out.println(">");

    }
}
