package heonuk.boj.sort_and_search._1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static String solution(int N, String[] words) {
        StringBuilder result = new StringBuilder();
        Set<String> uniqueWords = new HashSet<>(List.of(words));

        List<String> sortedWords = uniqueWords.stream()
                .sorted((a, b) -> {
                    if (a.length() == b.length()) { // 문자열 길이가 같은 경우
                        return a.compareTo(b); // 사전 순으로
                    } else { // 문자열 길이가 다른 경우
                        return Integer.compare(a.length(), b.length()); // 길이 비교
                    }
                })
                .collect(Collectors.toList());

        for (String word : sortedWords) {
            result.append(word).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        System.out.println(solution(N, words));
    }
}
