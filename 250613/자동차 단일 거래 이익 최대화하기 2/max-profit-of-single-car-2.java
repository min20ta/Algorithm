


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
    static int n ;
    static int m;
    static int k ;
    static int[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] v;


    static int maxDiff = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //n년간 정보, 한번사서 되팔때 이익 최대화
        minCar = arr[0];

        for (int i = 0; i < n; i++) {
            int diff = arr[i] - minCar;
            maxDiff = Math.max(maxDiff,diff);
            minCar = Math.min(minCar, arr[i]);
        }

        if (maxDiff < 0)
            System.out.println(0);
        else
            System.out.println(maxDiff);
    }


}




