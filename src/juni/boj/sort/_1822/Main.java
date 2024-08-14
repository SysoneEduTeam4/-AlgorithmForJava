package juni.boj.sort._1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> treeSet = new TreeSet<>();
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            treeSet.add(Integer.parseInt(inputs[i]));
        }
        inputs = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            int key = Integer.parseInt(inputs[i]);
            if(treeSet.contains(key)){
                treeSet.remove(key);
            }
        }
        if(treeSet.isEmpty()){
            sb.append(0);
        }else{
            sb.append(treeSet.size()).append("\n");
            for(int i:treeSet){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
}
