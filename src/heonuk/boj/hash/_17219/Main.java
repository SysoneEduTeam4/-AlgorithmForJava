package heonuk.boj.hash._17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String solution(int N, int M, String[] strArr, String[] searchPwd) {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        // 주소와 비밀번호를 Map에 저장
        for (String str : strArr) {
            String[] info = str.split(" ");
            map.put(info[0], info[1]); // info[0] = 주소, info[1] = 비밀번호
        }

        // 주소에 해당하는 비밀번호를 result에 추가
        for (String url : searchPwd) {
            result.append(map.get(url)).append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        String[] strArr = new String[N];
        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        String[] searchPwd = new String[M];
        for (int i = 0; i < M; i++) {
            searchPwd[i] = br.readLine();
        }
        System.out.println(solution(N, M, strArr, searchPwd));
    }

}
