package juni.boj.sort._10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        String[] inputs = br.readLine().split(" ");
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<inputs.length;i++){
            hashSet.add(Integer.parseInt(inputs[i]));
        }
        br.readLine();
        inputs = br.readLine().split(" ");
        for(int i=0;i<inputs.length;i++){
            if(hashSet.contains(Integer.parseInt(inputs[i]))){
                sb.append("1").append(" ");
            }else {
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb);
    }
}
