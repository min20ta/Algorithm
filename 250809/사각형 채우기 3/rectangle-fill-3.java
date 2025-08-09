


import java.util.*;
import java.io.*;


public class Main {



    static int n ;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        long [] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= n ; i++) {
            dp[i] = (2*dp[i-1] + 3*dp[i-2]) % 1000000007;

            for(int j = i-3 ; j >= 0 ; j--)
                dp[i] = (dp[i] + dp[j] * 2) % 1000000007;
        }

        System.out.println(dp[n]);


    }

}
