package juni.boj.hash._13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        String[] strNum = new String[k];
        for(int i=0;i<k;i++){
            strNum[i] = br.readLine();
        }
        System.out.println(Solution(n,k,strNum));
    }
    private static String Solution(int n,int k,String[] strNum){
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> hashMap = new HashMap<>();

        for(int i=0;i<k;i++){
            hashMap.put(strNum[i],i);
        }

        List<String> keySet = new ArrayList<>(hashMap.keySet());
        keySet.sort(Comparator.comparing(hashMap::get));

        if(keySet.size()<n){
            for(int i=0;i<keySet.size();i++){
                sb.append(keySet.get(i)).append("\n");
            }
        }else {
            for(int i=0;i<n;i++){
                sb.append(keySet.get(i)).append("\n");
            }
        }
        return sb.toString();
    }
}
