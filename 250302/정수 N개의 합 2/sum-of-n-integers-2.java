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
    static int k;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int [] arr= new int[n+1];
        int [] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1]+arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-2; i++) {
                int sum = dp[i+2]-dp[i];
                max = Math.max(max, sum);
            }


        System.out.println(max);





        }




    }



