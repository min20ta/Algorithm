


import java.util.*;
import java.io.*;


public class Main {


    static int n ;
    static int m ;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        int[] UpDp = new int[n];
        int[] DownDp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            UpDp[i] = 1;
            DownDp[i] = 1;
        }
//
//        UpDp[0] = 1;
//        DownDp[0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
//                if (UpDp[j] == Integer.MIN_VALUE)
//                    continue;

                if (arr[j] < arr[i])
                    UpDp[i] = Math.max(UpDp[i], UpDp[j] + 1);
            }
        }

        for (int i = n-1; i >= 0; i--) {

            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i])
                    DownDp[i] = Math.max(DownDp[i], DownDp[j]+1);
            }
        }

        int [] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = UpDp[i] + DownDp[i];
            max = Math.max(max, dp[i]);
        }




        System.out.println(max-1);



    }


}


