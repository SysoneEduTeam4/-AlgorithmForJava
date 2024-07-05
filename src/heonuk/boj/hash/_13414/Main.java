package heonuk.boj.hash._13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static String solution(int K, int L, String[] studentsId) {
        StringBuilder result = new StringBuilder();
        Set<String> classMate = new LinkedHashSet<>();

        for (String studentId : studentsId) {
            classMate.remove(studentId);
            classMate.add(studentId);
        }

        int limit = 0;
        for (String studentId : classMate) {
            if (limit >= K) {
                break;
            }
            result.append(studentId).append("\n");
            limit++;
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        String[] studentsId = new String[L];
        for (int i = 0; i < L; i++) {
            studentsId[i] = br.readLine();
        }
        System.out.println(solution(K, L, studentsId));
    }

}
