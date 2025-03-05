import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int [][] arr;
    static int [][] dp;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n ; i++) { //1번격자
            for (int j = 0; j <= n - 3; j++) {

                for (int l = 0; l < n; l++) { //2번 격지
                    for (int o = 0; o <= n -3; o++) {

                        max = Math.max(max,sumMax(i,j,l,o));


                    }
                }
            }
        }
        System.out.println(max);



    }
    //같은라인도
    static int sumMax(int x, int y, int x2, int y2) {
        int sum = 0;

        //검사
        if (x == x2 && y2 <= y +2)
            return 0;

        if (x == x2 && y >= y2)
            return 0;
        
        for (int i = y; i <y+3 ; i++) {
            sum += arr[x][i];
        }

        for (int i = y2; i < y2 + 3 ; i++) {
            sum += arr[x2][i];
        }
        return sum;
    }





    }












