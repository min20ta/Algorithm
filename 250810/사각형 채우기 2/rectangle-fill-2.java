


import java.util.*;
import java.io.*;


public class Main {



    static int n ;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        int [] dp = new int[n+1];


        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2])%100007;
        }


        System.out.println(dp[n]);

    }

}




