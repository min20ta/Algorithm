


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
    static int k;
    static int ans;
    static long [] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [] ansArr;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<pair> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new long[n];
        long sum = 0;
        long box ;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum+= arr[i];
        }

        box = sum/4;
        long [] dp = new long[n];
        L = new int[n];
        R = new int[n];

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1]+ arr[i];
        }

        if (L[0] == box)
            L[0] = 1;
        else
            L[0] = 0;

        for (int i = 1; i < n; i++) {
            if (dp[i] == box)
                L[i] = L[i-1]+1;
            else 
                L[i] = L[i-1];
        }

        R[n-1] = 0;
        for (int i = n-2; i >= 0 ; i--) {
            if (dp[i] == box*3)
                R[i] = R[i+1] + 1;
            else
                R[i] = R[i+1];
        }

        for (int i = 1; i < n-1; i++) {
            if (dp[i] == box*2){
                ans += (L[i-1]*R[i+1]);
            }
        }

        System.out.println(ans);
    }

    static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override  
        public int compareTo(pair p) {
            if (p.y == this.y)
                return this.x - p.x;
            return this.y - p.y;
        }
    }

}



