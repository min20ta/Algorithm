


import java.util.*;
import java.io.*;


public class Main {


    static int n ;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        pair [] arr = new pair[n];
        int [] dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            arr[i] = new pair(x1,x2);
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        // dp i = 해당 선분까지 겹치지 않는 선분개수 최대
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i].x;
            int y = arr[i].y;

            for (int j = 0; j < i ; j++) {
                int px = arr[j].x;
                int py = arr[j].y;

                if (py < x)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
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
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;

        }


    }

}




