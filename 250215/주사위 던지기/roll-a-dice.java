import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] dice = {{0,5,0},{4,6,3},{0,2,0},{0,1,0}};
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1,};
    static int[] dy = {-1, 0, 1, 0};
    static char [] dir ;
    static int n;
    static int m;
    static int r;
    static int c;
    static int x;
    static int y;
    static int stop;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); r--;
        c = Integer.parseInt(st.nextToken()); c--;



        map = new int[n][n];
        dir = new char[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dir[i] = st.nextToken().charAt(0);
        }

        int direction = 0;
        map[r][c] = 6;
        x = r; y = c;

        for (int i = 0; i < m; i++) {
            char c = dir[i];

            if (c == 'L') direction = 0;
            else if (c == 'D') direction = 1;
            else if (c == 'R') direction = 2;
            else if (c == 'U') direction = 3;

            move(direction);
            if (stop == 0)
                changeDice(direction);
//
//            for (int k = 0; k < 4; k++) {
//                for (int j = 0; j < 3; j++) {
//                    System.out.print(dice[k][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              //  System.out.print(map[i][j]+" ");
                sum += map[i][j];
            }
           // System.out.println();
        }

        System.out.println(sum);







    }

    static void move(int direction) {

        stop = 0;
        int curX = 1; int curY = 1;
        int diceX = curX + dx[direction];
        int diceY = curY + dy[direction];

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            map[nx][ny] = dice[diceX][diceY];
            x = nx; y = ny;
        }else {
            stop = 1;
        }
    }

    static void changeDice(int direction) {
        if (direction == 0) {
            int temp = dice[1][2];
            int temp2 = dice[3][1];
            for (int i = 2; i >= 1; i--) {
                dice[1][i] = dice[1][i-1];
            }
            dice[1][0] = temp2;
            dice[3][1] = temp;
        }else if (direction == 1) { //down
            int temp = dice[0][1];
            for (int i = 0; i < 3; i++) {
                dice[i][1] = dice[i+1][1];
            }
            dice[3][1] = temp;
        }else if (direction == 2) { //right
            int temp = dice[1][0];
            int temp2 = dice[3][1];
            for (int i = 0; i <= 1; i++) {
                dice[1][i] = dice[1][i+1];
            }
            dice[1][2] = temp2;
            dice[3][1] = temp;
        }else { //up
            int temp = dice[3][1];
            for (int i = 3; i >= 1; i--) {
                dice[i][1] = dice[i-1][1];
            }
            dice[0][1] = temp;
        }
    }
}

