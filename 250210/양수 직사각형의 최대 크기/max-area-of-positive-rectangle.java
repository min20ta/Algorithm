
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;






    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int h = 1; h+i <= n ; h++) {
                    for (int w = 1; w + j <= m ; w++) {
                        int num = checkSquare(i,j,h,w);
                      //  System.out.println(num+" "+i+" "+j+" "+h+" "+w);
                        max = Math.max(max, num);
                    }
                }
            }
        }
        if (max == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(max);

    }
    static int checkSquare(int x, int y, int h, int w) {

        for (int i = x ; i < x+h ; i++) {
            for (int j = y; j < y + w ; j++) {
                if (arr[i][j] <= 0)
                    return Integer.MIN_VALUE;
            }
        }
        return h*w;
    }

    }