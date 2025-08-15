


import java.util.*;
import java.io.*;


public class Main {


    static int n ;
    static int m ;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] coin = new int[n];
        int [] dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <=m; i++) {
            dp[i] = 10002;
        }

        for (int i = 0; i < n; i++) {
            dp[coin[i]] = 1;
        }

  
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coin[j]){
                    dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
                }
            }
        }


        if (dp[m] == 10002)
            System.out.println(-1);
        else
            System.out.println(dp[m]);







    }


}




