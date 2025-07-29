


import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int [] dp = new int[1001];
        
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        

        for (int i = 4; i <= n ; i++) {
                dp[i] = (dp[i-2] + dp[i-3]) % 10007;   
        }

        System.out.println(dp[n]);
    }

}



