


import java.util.*;
import java.io.*;


public class Main {


    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int n ;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][n];
        int [][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        //아무 시작점, 상하좌우 중 현재값보다 큰 곳, 움직칸 최대수

        //1 . 각 칸을 모두 시작위치로 잡은 후 bfs 실행 . n^4??
        //2. 해당칸 = 상하좌우 이전칸 중 값 작은거의 움직칸 최대수+1

        int max =Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 4; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];

                    if (px >= 0 && px < n && py >= 0 && py < n) {
                        if (arr[i][j] > arr[px][py]) {
                            dp[i][j] = Math.max(dp[i][j], dp[px][py] + 1);
                        }
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);


    }

}




