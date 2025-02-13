import java.util.*;
import java.io.*;


public class Main {
    static int[][] grid;
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        int[] bomb = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            bomb[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            int line = bomb[i] - 1;
            bombing(line);
            gravity();

        }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[k][j] + " ");
                }
                System.out.println();
            }

    }

    //폭탄후 밑으로
    static void bombing(int line) {
        int x = -1; int y = -1;
        for (int i = 0; i < n; i++) {
            if (grid[i][line] != 0) {
                x = i; y = line;
                break;
            }
        }

        if (x == -1 && y == -1)
            return;

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
}
