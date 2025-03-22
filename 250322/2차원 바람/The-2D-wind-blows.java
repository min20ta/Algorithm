
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[][] copyArr;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int q;

    static int max = Integer.MIN_VALUE;
    static int count = 0;




    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        //0~9 q번 바람
        //바람 : 시계방향 회전
            //현재칸 + 4개 값 평균.
        arr = new int[n][m];
        copyArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()); r1--;
            int c1 = Integer.parseInt(st.nextToken()); c1--;
            int r2 = Integer.parseInt(st.nextToken()); r2--;
            int c2 = Integer.parseInt(st.nextToken()); c2--;

            //1. 회전
            rotateByWind(r1, c1, r2, c2);
            //2. 평균
            getAvg(r1, c1, r2, c2);

        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(arr[j][k] +" ");
            }
            System.out.println();
        }
    }
    static void rotateByWind(int r1, int c1, int r2, int c2) {
       int temp = arr[r1][c2];
        for (int i = c2; i > c1 ; i--) {
            arr[r1][i] = arr[r1][i-1];
        }

        int temp2 = arr[r2][c2];
        for (int i = r2; i > r1+1 ; i--) {
            arr[i][c2] = arr[i-1][c2];
        }
        arr[r1+1][c2] = temp;

        temp = arr[r2][c1];
        for (int i = c1; i < c2 -1  ; i++) {
            arr[r2][i] = arr[r2][i+1];
        }
        arr[r2][c2-1] = temp2;

        for (int i = r1; i < r2-1; i++) {
            arr[i][c1] = arr[i+1][c1];
        }
        arr[r2-1][c1] = temp;
    }

    static void getAvg(int r1, int c1, int r2, int c2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        for (int i = r1; i <= r2 ; i++) {
            for (int j = c1; j <= c2 ; j++) {
                calcAvg(i,j);
            }
        }
    }

    static void calcAvg(int x, int y) {

        int sum = copyArr[x][y];
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                sum += copyArr[nx][ny];
                count++;
            }
        }

        int num = sum / count;
        arr[x][y] = num;


    }

  static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
  }
}