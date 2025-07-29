


import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int [] dp = new int[n+1];
        
        dp[2] = 1;
        

        for (int i = 3; i <= n ; i++) {
            if(i % 2 == 0) 
                dp[i] = 1;
            else 
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;   
        }

        System.out.println(dp[n]);
    }

}



