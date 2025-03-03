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
        int []dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
                arr[i]= Integer.parseInt(st.nextToken());
        }

        // 연속합k인거 개수
        for (int i = 1; i <= n ; i++) {
                dp[i] = dp[i-1] + arr[i];
        }

        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <= n; j++) {
                int num = dp[j] - dp[i];
                if (num == k)
                    count++;
            }
        }

        System.out.println(count);
        

        





        }




    }



