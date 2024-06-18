package heonuk.boj.linked_list._1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {

    public static String solution(int n, int k) {
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(list::add);

        int idx = 0;
        result.append("<");
        while (list.size() > 1) {
            idx = (idx + k - 1) % list.size();
            result.append(list.remove(idx)).append(", ");
        }
        result.append(list.remove()).append(">");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        System.out.println(solution(n, k));
    }

}
