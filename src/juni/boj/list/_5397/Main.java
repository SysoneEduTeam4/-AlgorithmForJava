package juni.boj.list._5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            List<String> linkedList = new LinkedList<>();
            String sentence = br.readLine();
            String[] sentences = sentence.split("");
            /*
            새로 알게된 개념 : ListIterator
            List 전용 Iterator로 양방향으로 탐색이 가능한것이 특징이다.
            cursor의 위치는 요소를 가리키고 있는 것이 아닌 요소와 요소 사이에 있다.
             */
            ListIterator<String> iter = linkedList.listIterator();

            for (int j = 0; j < sentences.length; j++) {
                if (sentences[j].equals("<")) {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (sentences[j].equals(">")) {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (sentences[j].equals("-")) {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }else{
                    iter.add(sentences[j]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String s : linkedList){
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
