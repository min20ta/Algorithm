import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int q;
    static int b;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int [] arr= new int[100001];
        int [] dp= new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]= 1;
        }


        //n개 점/q범위 내에 점 몇개 있는지
        for (int i = 1; i <= 100000; i++) {
            dp[i] = dp[i-1] + arr[i];

        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

        //    if (dp[end] != dp[start])
                System.out.println(dp[end] - dp[start-1]);
          //  else
             //   System.out.println(0);

        }
    }










}

