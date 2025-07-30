


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int n ;
    static int m;
    static int q ;
    static int[][] arr;
    static int[] num;
    static int[] orderArr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());


        arr = new int[n][m];
        

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (q-- > 0) {
            visit = new boolean[n];
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            char d = st.nextToken().charAt(0);
            
            if (d == 'L') {
                move(1,r);
            } else if (d == 'R') {
                move(-1,r);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }



    }
    static void move(int d, int row) {
        if (d == 1) { //왼
            int temp = arr[row][m-1];
            for (int i = m-1; i > 0; i--) {
                arr[row][i] = arr[row][i-1];
            }
            arr[row][0] = temp;

            visit[row] = true;
            wave(1,row);


        }else if (d == -1) { //오
            int temp = arr[row][0];
            for (int i = 0; i < m-1 ; i++) {
                arr[row][i] = arr[row][i+1];
            }
            arr[row][m-1] = temp;

            visit[row] = true;
            wave(-1,row);
        }
    }

    static void wave(int d, int row) {
        //해당 행 윗부분

        int upRow = row - 1;
        if (upRow >= 0 && ! visit[upRow]) {
            visit[upRow] = true;
            boolean haveSame = false;

            for (int i = 0; i < m; i++) {
                if (arr[row][i] == arr[upRow][i]) {
                    haveSame = true;
                    break;
                }
            }

            if (haveSame) {
                move(d * (-1), upRow);
            }
        }



        //아래부분
        int downRow = row + 1;
        if (downRow < n && !visit[downRow]) {
            visit[downRow] = true;
            boolean haveSame = false;

            for (int i = 0; i < m; i++) {
                if (arr[row][i] == arr[downRow][i]) {
                    haveSame = true;
                    break;
                }
            }

            if (haveSame) {
                move(d * (-1), downRow);
            }
        }

    }

}



