package juni.boj.sort._2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Number{
            int rank;
            int value;
            int count;

            public Number(int rank, int value, int count) {
                this.rank = rank;
                this.value = value;
                this.count = count;
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs= br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);
        Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        inputs = br.readLine().split(" ");
        for(int i=0;i<inputs.length;i++){
            int key = Integer.parseInt(inputs[i]);
            if(linkedHashMap.containsKey(key)){
                int value = linkedHashMap.get(key);
                linkedHashMap.put(key,++value);
            }else{
                linkedHashMap.put(key,1);
            }
        }

        List<Number> arrList = new ArrayList<>();
        int rank = 1;
        for(Map.Entry<Integer,Integer>entry : linkedHashMap.entrySet()){
            arrList.add(new Number(rank++,entry.getKey(), entry.getValue()));
        }
        Comparator<Number> comp = new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                int result = o2.count-o1.count;
                if(o1.count == o2.count){
                    result= o1.rank-o2.rank;
                }
                return result;
            }
        };
        Collections.sort(arrList,comp);
        for(Number a : arrList){
            for(int i=0;i<a.count;i++){
                sb.append(a.value+" ");
            }
        }
        System.out.println(sb);

    }
}
