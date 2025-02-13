import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] grid;
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        map = new int[n][n];
        grid = new int[n][n];
        int[] bomb = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.arraycopy(map[k],0,grid[k],0,n);
                    bombing(i,j);
                    gravity();
                    findMax();
                }
            }
        }

        System.out.println(max);

    }

    //폭탄후 밑으로
    static void bombing(int x, int y) {

        int range = grid[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int distance = Math.abs(x - i) + Math.abs(y - j);

                if ((i == x || j == y) && distance < range) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    static void gravity() {
        temp = new int[n][n];

        for (int j = 0; j < n; j++) {
            int index = n-1;
            for (int i = n-1; i >= 0; i--) {
                if (grid[i][j]!=0) {
                    temp[index--][j] = grid[i][j];
                }
            }
        }

        //다시 grid로 옮기기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }

    static void findMax() {
        int count = 0;
        //가로 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (grid[i][j]!= 0
                    && grid[i][j] == grid[i][j+1])
                    count++;
            }
        }

        //세로 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (grid[j][i]!=0
                        &&grid[j][i] == grid[j+1][i])
                    count++;
            }
        }

        max = Math.max(max, count);

    }
}
