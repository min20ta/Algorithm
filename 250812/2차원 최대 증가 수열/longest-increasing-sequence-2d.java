


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

        int [][] arr = new int[n][m];
        int [][] dp = new int[n][m];
        List<pair> list = new ArrayList<>();

        //(0,0)에서 시작해야함!
        int first = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0 && j == 0)
                    first = arr[i][j];

                if (first < arr[i][j])
                    list.add(new pair(arr[i][j], i,j));
            }
        }

        Collections.sort(list);
        list.add(0,new pair(first, 0,0));

        dp[0][0] = 1;
       

        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            int num = list.get(i).num;

            for (int j = 0; j <= x; j++) {
                for (int k = 0; k <= y; k++) {
                    if(dp[j][k] == 0)
                        continue;

                    if (arr[j][k] < num && x-j >= 1 && y - k >= 1)
                        dp[x][y] = Math.max(dp[j][k]+1, dp[x][y]);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }


        System.out.println(ans);







    }

    static class pair implements Comparable<pair>{
        int num;
        int x;
        int y;

        pair(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p) {
            return this.num - p.num;
        }
    }

}




