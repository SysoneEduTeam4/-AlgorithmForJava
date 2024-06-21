package bakejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		String[] array = new String[Integer.parseInt(n)];
		array = br.readLine().split(" ");

		int x = Integer.parseInt(br.readLine());
		int[] array2 = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(array2);
		
		int count = 0;
		int sum = 0;
		int start = 0;
		int end = array2.length - 1;
		
		while(start < end) {
			sum = array2[start] + array2[end];
			
			if (sum == x) {
				count++;
				start++;
				end--;
			} else if (sum < x) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(count);

	}

}
