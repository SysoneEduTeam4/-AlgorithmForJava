package heonuk.boj.linked_list._5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static String solution(char[] keyLog) {
        LinkedList<Character> passwordList = new LinkedList<>();
        ListIterator<Character> iterator = passwordList.listIterator();

        for (char key : keyLog) {
            switch (key) {
                case '<':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case '>':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case '-':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(key);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char password : passwordList) {
            result.append(password);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] arr = br.readLine().toCharArray();
            result.append(solution(arr)).append("\n");
        }
        System.out.print(result);
    }

}
