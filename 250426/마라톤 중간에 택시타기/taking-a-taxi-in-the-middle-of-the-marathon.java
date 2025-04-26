
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static int [] x;
    static int [] y;
    static int [] L;
    static int [] R;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        x = new int[n];
        y = new int[n];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        L = new int[n]; //처음~i까지 인접합
        R = new int[n]; //i~ 끝까지 인접합
        L[0] = 0;
        R[n-1] = 0;

        for (int i = 1; i < n ; i++) {
             L[i] = L[i-1] + Math.abs(x[i]-x[i-1]) + Math.abs(y[i] - y[i-1]);
        }

        for (int i = 1; i < n; i++) {
            R[i] = L[n-1] - L[i];
        }

        for (int i = 1; i < n-1; i++) { //하나 건너뛰기
            min = Math.min(min, L[i-1]+R[i+1]+Math.abs(x[i+1]-x[i-1]) + Math.abs(y[i+1]-y[i-1]));
        }

        System.out.println(min);
    }



}


