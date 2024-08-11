package juni.boj.sort._5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        long[] arr = new long[count];
        while(count>0){
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                String temp = "";
                for(int i=word.length()-1;i>=0;i--){
                    temp+= word.charAt(i);
                }
                count--;
                arr[count] = Long.parseLong(temp);
            }
            if(count>0){
                st = new StringTokenizer(br.readLine());
            }
        }
        Arrays.sort(arr);
        for(long i:arr){
            System.out.println(i);
        }
    }
}


