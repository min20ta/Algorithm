


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

        int [] arr = new int[n];
        int [] dp = new int[m+1];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
        }

        //최소길이는 뒤에서 부터 구해도된다?
        //부분수열 + 합까지 고려를 해야함. dp는 합일때 최소길이

        for (int i = 0; i <= m; i++) {
            dp[i] = 10001;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0 ; j--) {
                if (j >= arr[i])
                    dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }


        if (dp[m] == 10001)
            System.out.println(-1);
        else
            System.out.println(dp[m]);




    }


}




