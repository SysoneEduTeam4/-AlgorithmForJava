package juni.boj.stack._18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] orders = new String[n];
        for(int i=0;i< orders.length;i++){
            orders[i] = br.readLine();
        }
        Solution(orders);
    }

    private static void Solution(String[] orders) {
        Queue<String> q = new LinkedList<>();
        String last = "";
        StringBuilder sb = new StringBuilder();
        for(String order : orders){
            if(order.contains("push")){
                String[] pushs = order.split(" ");
                q.add(pushs[1]);
                last = pushs[1];
            }
            if(order.equals("pop")){
                sb.append(q.isEmpty()?"-1":q.poll());
                sb.append("\n");
            }
            if(order.equals("front")){
                sb.append(q.isEmpty()?"-1":q.peek());
                sb.append("\n");
            }
            if(order.equals("back")){
                sb.append(q.isEmpty()?"-1":last);
                sb.append("\n");
            }
            if(order.equals("size")){
                sb.append(q.size());
                sb.append("\n");
            }
            if(order.equals("empty")){
                sb.append(q.isEmpty()?"1":"0");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
