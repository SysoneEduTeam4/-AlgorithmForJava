package boj.stack_queue_deque._1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] array = new int[M];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			int targetIndex = 0;
			for(int j : deque) {
				if(array[i] == j) {	//1번 연산 확인 분기문
					//deque.poll();
					break;
				}
				targetIndex++;	//찾고자 하는 위치 파악
			}
			
			int checkSize = deque.size() / 2;
			
			
			if (targetIndex <= checkSize) {	 //찾고자 하는 위치가 중간 위치의 앞에 있을 경우(2번 연산)
				for (int j = 0; j < targetIndex; j++) {
					deque.offerLast(deque.poll());
					count++;
				}
			} else {	//3번연산
				for (int j = 0; j < deque.size() - targetIndex; j++) {
					deque.offerFirst(deque.pollLast());
					count++;
				}
			}
			deque.poll();
		}
		
		System.out.println(count);
		
	}
}
