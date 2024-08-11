package juni.boj.sort._1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        class Word{
            String word;
            int size;

            public Word(String word){
                this.word = word;
                this.size = word.length();
            }

            public String getWord(){
                return word;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        List<Word> arrList = new ArrayList<>();
        for(int i=0;i<count;i++){
            arrList.add(new Word(br.readLine()));
        }
        Comparator<Word> comp = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int result = o1.size-o2.size;
                if(result==0){
                    result = o1.getWord().compareTo(o2.getWord());
                }
                return result;
            }
        };

        Collections.sort(arrList,comp);
        sb.append(arrList.get(0).getWord()+"\n");
        for(int i=1;i<arrList.size();i++){
            String prev = arrList.get(i-1).getWord();
            if(!prev.equals(arrList.get(i).getWord())){
                sb.append(arrList.get(i).getWord()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
