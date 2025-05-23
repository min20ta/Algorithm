
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static int[][] arr;
    static int[][] tempArr;
    static int[] L;
    static int[] R;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        tempArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()); r1--;
            int c1 = Integer.parseInt(st.nextToken()); c1--;
            int r2 = Integer.parseInt(st.nextToken()); r2--;
            int c2 = Integer.parseInt(st.nextToken()); c2--;

            rotate(r1,c1,r2,c2);
            makeMean(r1,c1,r2,c2);
            changeArr();
        }

        //0~9, q번 바람
        // 시계방향 회전
        // 5개칸 평균

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }

    static void rotate(int r1, int c1, int r2, int c2) {

        //회전문제 : temp사용, 없어질거 먼저

        int temp = arr[r1][c1];

        for (int i = r1+1; i <= r2 ; i++) {
            arr[i-1][c1] = arr[i][c1];
        }
        for (int i = c1+1; i <= c2 ; i++) {
            arr[r2][i-1] = arr[r2][i];
        }
        for (int i = r2-1; i >= r1 ; i--) {
            arr[i+1][c2] = arr[i][c2];
        }
        for (int i = c2-1; i >= c1+1 ; i--) {
            arr[r1][i+1] = arr[r1][i];
        }
        arr[r1][c1+1] = temp;
    }

    static void makeMean(int r1, int c1, int r2, int c2) {

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {

                int x = i; int y = j;
                int sum = arr[x][y];
                int count = 1;

                for (int p = 0; p < 4; p++) {
                    int nx = x + dx[p];
                    int ny = y + dy[p];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        sum += arr[nx][ny];
                        count++;
                    }
                }

                int mean = sum/count;
                tempArr[x][y] = mean;
            }
        }

    }

    static void changeArr() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = tempArr[i][j];
            }
        }
    }
}



