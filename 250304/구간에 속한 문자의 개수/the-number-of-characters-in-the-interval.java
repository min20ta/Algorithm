import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int k;
    static int b;

    static int sumA = 0;
    static int sumB = 0;
    static int sumC = 0;
    static int[][] dpA = new int[n + 1][m + 1];
    static int [][] dpB = new int[n + 1][m + 1];
    static int [][] dpC = new int[n + 1][m + 1];




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        int[][] c = new int[n + 1][m + 1];

        dpA = new int[n + 1][m + 1];
        dpB = new int[n + 1][m + 1];
        dpC = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                String value = str.charAt(j-1)+ "";
                if (value.equals("a"))
                    a[i][j] = 1;
                else if (value.equals("b"))
                    b[i][j] = 1;
                else if (value.equals("c"))
                    c[i][j] = 1;

                //System.out.println(value.equals("a"));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dpA[i][j] = dpA[i - 1][j] + dpA[i][j - 1] - dpA[i - 1][j - 1] + a[i][j];
                dpB[i][j] = dpB[i - 1][j] + dpB[i][j - 1] - dpB[i - 1][j - 1] + b[i][j];
                dpC[i][j] = dpC[i - 1][j] + dpC[i][j - 1] - dpC[i - 1][j - 1] + c[i][j];
                //System.out.print(dpA[i][j] +" ");
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            squareSum(r1,c1,r2,c2);
            System.out.println(sumA+" "+sumB+" "+sumC);


        }

    }
        static void squareSum(int r1, int c1, int r2, int c2)  {
            sumA = dpA[r2][c2] - dpA[r1-1][c2] - dpA[r2][c1-1] + dpA[r1-1][c1-1];
            sumB = dpB[r2][c2] - dpB[r1-1][c2] - dpB[r2][c1-1] + dpB[r1-1][c1-1];
            sumC = dpC[r2][c2] - dpC[r1-1][c2] - dpC[r2][c1-1] + dpC[r1-1][c1-1];

    }

    }










