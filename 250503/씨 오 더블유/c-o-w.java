

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
    static int k;
    static int end;
    static char [] arr;
    static int[][] tempArr;
    static int[] L;
    static int[] R;
    static int ans = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        arr = str.toCharArray();
        L = new int[n];
        R = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'C')
                count++;

            L[i] = count;
        }

        count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] == 'W')
                count++;

            R[i] = count;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'O'){
                ans += (L[i-1] * R[i+1]);
            }
        }

        System.out.println(ans);


    }
}



