import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] grid;
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, 0,};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int k;

    static int endIndex;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        k--;


        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        block();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    static void block() {
        int start = k; //1열부터 3열
        int end = k + m - 1;

        for (int i = n-1; i >= 0; i--) {
            int count = 0;
            int startIdx = start;
            for (int j = start; j <= end; j++) {

                if (i == 0 && map[i][j] == 0) {
                    count++;

                    if (count >= m) {
                        //System.out.println(check(startIdx, i, j));
                        if (check(startIdx,i, j)) {
                            for (int l = startIdx; l < startIdx + m; l++) {
                                map[i][l] = 1;
                            }
                            return;
                        }
                    }
                }
                else if (map[i][j] == 0 && map[i - 1][j] == 0) {
                    count++;

                    if (count >= m) {
                     //   System.out.println(check(startIdx, i, j));
                        if (check(startIdx, i, j)) {
                            for (int l = startIdx; l < startIdx + m; l++) {
                                map[i][l] = 1;
                            }
                            return;
                        }
                    }

                } else {
                    startIdx = j+1;
                    count = 0;
                }
            }
        }
    }


    static boolean check(int startIdx, int row, int endCol) {

        if (row == n-1)
            return true;

        for (int i = startIdx; i < endCol; i++) {
            int x = row;
            int y = startIdx;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 1 ) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
