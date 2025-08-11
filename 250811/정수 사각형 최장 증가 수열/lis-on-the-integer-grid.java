


import java.util.*;
import java.io.*;


public class Main {


    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int n ;
    static ArrayList<pair> list= new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][n];
        int [][] dp = new int[n][n];

        int max =Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                list.add(new pair(arr[i][j], i , j));
            }
        }

        Collections.sort(list);


        //아무 시작점, 상하좌우 중 현재값보다 큰 곳, 움직칸 최대수

        //1 . 각 칸을 모두 시작위치로 잡은 후 bfs 실행 . n^4??
        //2. 해당칸 = 상하좌우 이전칸 중 값 작은거의 움직칸 최대수+1



        //중간 갱신이 문제인데....
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < list.size(); i++) {
                int x = list.get(i).x;
                int y = list.get(i).y;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (arr[x][y] < arr[nx][ny]) {
                            dp[nx][ny] = Math.max(dp[x][y] + 1, dp[nx][ny]);
                        }
                    }
                }
            }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);


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



