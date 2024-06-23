package juni.boj.array._2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        result = sc.nextInt()*sc.nextInt()*sc.nextInt();
        String resultStr = String.valueOf(result);
        String[] resultsStr = resultStr.split("");
        int[] results = new int[10];
        for(String r : resultsStr){
            results[Integer.parseInt(r)]++;
        }
        for(int r : results){
            System.out.println(r);
        }
    }
}