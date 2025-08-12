


import java.util.*;
import java.io.*;


public class Main {

    static int n ;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        int [] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MIN_VALUE)
                    continue;
                
                if (arr[j] >= i - j)
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }


        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);







    }

}