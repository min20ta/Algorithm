
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;
    static boolean noUnder;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //1*m
        //닫으면 멈툼
        //k~k+m-1
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행 찾기
        int r = findRow();

        for (int i = k-1; i < k+m-1; i++) {
            arr[r][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }



    static int findRow() {// 아래판단

        for (int row = 0; row < n-1; row++) {
            boolean block = false;

            for (int col = k-1; col <= k + m - 2; col++) {
                if (arr[row+1][col] == 1) {
                    block = true;
                }
            }
            if (block) //최초 아래
                return row ;
        }
        return n-1;
    }

}


