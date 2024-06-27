package heonuk.boj.array._1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(char[] cards) {
        int[] numberCounts = new int[10];
        for (char card : cards) {
            int number = Character.getNumericValue(card);
            if (number == 6 || number == 9) { // 6과 9는 같은 숫자로 취급하기 위한 조건식
                numberCounts[9]++;
            } else {
                numberCounts[number]++;
            }
        }
        int sixNineCardsCount = (numberCounts[9] + 1) / 2;

        int maxSetCount = 0;
        for (int i = 0; i < 9; i++) {
            maxSetCount = Math.max(maxSetCount, numberCounts[i]);
        }

        return Math.max(maxSetCount, sixNineCardsCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cards = br.readLine().toCharArray();
        System.out.println(solution(cards));
    }

}
