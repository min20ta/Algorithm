


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int q;
    static int ans;
    static int [] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [] ansArr;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        L = new int[n];
        R = new int[n];
        L[0] = arr[0];
        R[n-1] = arr[n-1];

        for (int i = 1; i < n; i++) {
            if (L[i-1] < arr[i])
                L[i] = L[i-1] + 1;
            else
                L[i] = L[i-1];
        }

        for (int i = n-2; i >= 0 ; i--) {
            if (R[i+1] < arr[i])
                R[i] = R[i+1] + 1;
            else
                R[i] = R[i+1];
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); a--;
            int b = Integer.parseInt(st.nextToken()); b--;

            if(a-1 >= 0 && b+1 < n) 
                ans = Math.max(L[a-1], R[b+1]);
            else if(a-1 < 0)
                ans =R[b+1];
            else
                ans = L[a-1];
                            
            System.out.println(ans);
        }
    }

}



