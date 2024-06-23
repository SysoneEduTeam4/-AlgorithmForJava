package juni.boj.array._1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int max=0;
        String input = sc.nextLine();
        String[] numArr = input.split("");
        for(int i=0;i<input.length();i++){
            numbers[Integer.parseInt(numArr[i])]++;
        }
        for(int i=0;i<numbers.length;i++){
            if(i==6||i==9){
                continue;
            }
            if(max<numbers[i]){
                max = numbers[i];
            }
        }

        int tmpMax = Math.max(numbers[6],numbers[9]);
        int tmpMin = Math.min(numbers[6],numbers[9]);
        if(max>=tmpMax){
            System.out.println(max);
            return;
        }else {
            if(max*2<=tmpMax){
                max = tmpMin + (tmpMax-tmpMin)/2 + (tmpMax-tmpMin)%2;
                System.out.println(max);
                return;
            }
            System.out.println(max);
        }
    }
}
