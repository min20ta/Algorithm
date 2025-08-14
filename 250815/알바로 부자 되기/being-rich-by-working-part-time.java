


import java.util.*;
import java.io.*;


public class Main {


    static int n ;
    static int m ;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [] s = new int[n];
        int [] e = new int[n];
        int [] p = new int[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

                s[i] = Integer.parseInt(st.nextToken());
                e[i] = Integer.parseInt(st.nextToken());
                p[i] = Integer.parseInt(st.nextToken());

        }


        int [] dp = new int[n];
        dp[0] = p[0];

        for (int i = 1; i < n; i++) {
            int start = s[i];
            int end = e[i];

            for (int j = 0; j < i; j++) {
                int pstart = s[j];
                int pend = e[j];

                if (end < pstart) {
                    dp[i] = Math.max(dp[i], dp[j] + p[i]);
                } else {
                    dp[i] = p[i];
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


    }


}



