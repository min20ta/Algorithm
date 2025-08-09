


import java.util.*;
import java.io.*;


public class Main {



    static int n ;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        int [] dp = new int[n+1];
      
        dp[1] = 2;

        for (int i = 2; i <= n ; i++) {
            if (i == 2) {
                dp[i] = 7;
                continue;
            }
            dp[i] = (2*dp[i-1] + 4*dp[i-2]) % 1000000007;
        }

        System.out.println(dp[n]);


    }

}
