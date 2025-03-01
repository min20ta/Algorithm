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
        int [][] arr= new int[n+1][n+1];
        int [][] dp = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());    
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n ; i++) {
            for (int j = k; j <= n; j++) {
                int sum = dp[i][j] -dp[i-k][j]
                        - dp[i][j-k] + dp[i-k][j-k];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
        

        





        }




    }



