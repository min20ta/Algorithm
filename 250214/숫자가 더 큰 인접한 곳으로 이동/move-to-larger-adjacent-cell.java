import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] grid;
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0 , -1, 1};
    static int n;
    static int r;
    static int c;
    static pair [] priority;
    static int endIndex;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); r--;
        c = Integer.parseInt(st.nextToken()); c--;


        map = new int[n][n];
        priority = new pair[4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(map[r][c]+" ");
        findMax(r,c);

    }
    static void findMax(int r, int c) {

        int x = r; int y = c;
        while(true) {
            priority = new pair[4];
            for (int i = 0; i < 4; i++) {
                priority[i] = new pair(-1,-1,0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] > map[x][y]) {
                        priority[i]  = new pair(nx,ny,map[nx][ny]);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (priority[i].val != 0) {
                    x = priority[i].x;
                    y = priority[i].y;
                    System.out.print(priority[i].val+" ");
                    break;
                }else {
                    count++;
                }
            }


            if (count == 4)
                break;
        }
    }

    static class pair {
        int x ; int y; int val;

        pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }



}
