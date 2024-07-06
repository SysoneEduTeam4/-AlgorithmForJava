package juni.boj.hash._9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int t = 0;t<test_case;t++){
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> hashMap = new HashMap<>();
            for(int i=0;i<n;i++){
                String[] inputs = br.readLine().split(" ");
                String kind = inputs[1];
                if(hashMap.containsKey(kind)){
                    hashMap.put(kind,hashMap.get(kind)+1);
                }else {
                    hashMap.put(kind,1);
                }
            }
            int result = 1;
            List<Integer> valueList = new ArrayList<>(hashMap.values());
            for(int value : valueList){
                result *= (value+1);
            }
            result--;
            System.out.println(result);
        }

    }
}
