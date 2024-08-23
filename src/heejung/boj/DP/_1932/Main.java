package _1932;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
           for(int j=0;j<=i;j++){
               arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        int result[][] = new int[n][n];
        result[0][0] =  arr[0][0];
        int max=arr[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++) {
                if (j == 0) {
                        result[i][j] = result[i-1][j]+arr[i][j];
                } else if(j==i){
                        result[i][j] = result[i-1][j-1]+arr[i][j];
                } else{
                    result[i][j] = Math.max(result[i - 1][j] + arr[i][j],result[i-1][j-1]+arr[i][j] );


                if(max<result[i][j]){
                    max = result[i][j];
                }
            }

        }

        System.out.println(max);


    }
}
