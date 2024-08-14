package heonuk.boj.sort_and_search._1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static String solution(int[] arrA, int[] arrB) {
        StringBuilder result = new StringBuilder();

        Set<Integer> setA = Arrays.stream(arrA)
                .boxed()
                .collect(Collectors.toSet());

        for (int num : arrB) {
            setA.remove(num);
        }

        Set<Integer> sortedSet = new TreeSet<>(setA);

        result.append(sortedSet.size()).append("\n");
        for (int num : sortedSet) {
            result.append(num).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] arrA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arrB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(arrA, arrB));
    }

}
