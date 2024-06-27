package hyukkyu.boj.queue._18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int num;
		int lastNum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			num = 0;
			 switch(str) {
				 case "push" :
					 num = Integer.parseInt(st.nextToken());
					 lastNum = num;
					 queue.offer(num);
					 break;
				 case "pop" :
					 if(queue.isEmpty()) {
						 num = -1;
					 } else {
						 num = queue.poll();
					 }
					 sb.append(num + "\n");
					 break;
				 case "size" :
					 sb.append(queue.size() + "\n");
					 break;
				 case "empty" :
					 num = queue.isEmpty() ? 1 : 0;
					 sb.append(num + "\n");
					 break;
				 case "front" :
					 num = queue.isEmpty() ? -1 : queue.peek();
					 sb.append(num + "\n");
					 break;
				 case "back" :
					 num = queue.isEmpty() ? -1 : lastNum;
					 sb.append(num + "\n");
					 break;
				 default :
					 break;
			 }
		}
		System.out.println(sb);
	}
}
