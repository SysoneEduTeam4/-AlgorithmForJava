package juni.boj.dfs._1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[][] papers;
    public static int MINUSPAPER=0;
    public static int ZEROPAPER=0;
    public static int PLUSPAPER=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        papers = new int[n][n];
        for(int i=0;i<n;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                papers[i][j] = Integer.parseInt(line[j]);
            }
        }

        recursive(0,0,n);
        System.out.println(MINUSPAPER);
        System.out.println(ZEROPAPER);
        System.out.println(PLUSPAPER);

    }

    public static void recursive(int x,int y,int size){
        if(check(x,y,size)){
            if(papers[x][y]==-1){
                MINUSPAPER++;
            }else if(papers[x][y]==0){
                ZEROPAPER++;
            }else{
                PLUSPAPER++;
            }
            return;
        }
        int length = size/3;
        recursive(x,y,length);
        recursive(x,y+length,length);
        recursive(x,y+2*length,length);

        recursive(x+length,y,length);
        recursive(x+length,y+length,length);
        recursive(x+length,y+2*length,length);

        recursive(x+2*length,y,length);
        recursive(x+2*length,y+length,length);
        recursive(x+2*length,y+2*length,length);
    }

    public static boolean check(int x,int y,int size){
        int number = papers[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(papers[i][j]!=number){
                    return false;
                }
            }
        }
        return true;
    }
}
