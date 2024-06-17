package heonuk.boj.array._3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int n, int[] arr, int x) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int count = 0;

        Arrays.sort(arr);
        while (leftPointer < rightPointer) {
            int sum = arr[leftPointer] + arr[rightPointer];
            if (sum == x) {
                count++;
            }

            if (sum > x) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
//				.sorted()
                .toArray();
        int x = Integer.parseInt(br.readLine());
        System.out.println(solution(n, arr, x));
    }

}

