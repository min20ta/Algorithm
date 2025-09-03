


import java.util.*;
import java.io.*;


public class Main {


    static List<Integer> list = new ArrayList<>();
    static int type = 0;
    static int max = Integer.MIN_VALUE;
    static int [] alpha ;
    static String str;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] coin = new int[n];
        int [] dp = new int[m+1];
        for (int i = 0; i <=m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < n ; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for(int i = 0 ; i <= m ; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coin[j]){
                    if (dp[i-coin[j]] == Integer.MIN_VALUE)
                        continue;
                    dp[i] = Math.max(dp[i],dp[i-coin[j]]+1);
                }
            }
        }

        if (dp[m] == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[m]);

    }


}




