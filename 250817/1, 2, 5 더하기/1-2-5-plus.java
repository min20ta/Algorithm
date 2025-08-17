


import java.util.*;
import java.io.*;


public class Main {


    static int n ;
    static int m ;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [] arr = {1,2,5};
        int [] dp = new int[n+1];

        //초기값, dp식

        dp[0] = 1;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= arr[j])
                    dp[i] = (dp[i] + dp[i-arr[j]]) % 10007;
            }
        }

        System.out.println(dp[n]);








    }


}

