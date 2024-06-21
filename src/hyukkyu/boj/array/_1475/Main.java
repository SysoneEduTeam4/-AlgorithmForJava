package hyukkyu.boj.array._1475;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int [] count = new int [10]; 
        for(int i = 0; i < N.length(); i++){ 
            int num = Integer.parseInt(String.valueOf(N.charAt(i)));
            
            if(num == 9) {// 9와 6을 하나로 판단
                count[6]++;
            } else {
                count[num]++;
            }
        }
        
        //6과9 반으로 나누어 준다
        if (count[6] % 2 == 1) {	
        	count[6] = count[6] / 2 + 1;
        } else {	
        	count[6] = count[6] / 2;
        }
        
        int max = 0;
        
        for (int i = 0; i < count.length; i++) {
        	max = Math.max(max, count[i]);
        }

        System.out.println(max); 
	}

}
