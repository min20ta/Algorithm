


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int c;
    static int ans;
    static int [] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] == 0){
                arr[i-1] = 1;
                arr[i] = 1-arr[i+1];
                if (i+1 < n)
                    arr[i+1] = 1- arr[i+2];
                count++;
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if(arr[i] != 1){
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(count);



    }



}


