

import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
//    static int[] dx = {0, 1, -1, 0};
//    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int ans;
    static pair [] arr;
    static int[] tempArr;
    static int[] L;
    static int[] R;
    static int size = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new pair(x,y);
        }

        Arrays.sort(arr);
        L = new int[n]; //i번까지 x2 최대값
        L[0] = arr[0].y;
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(arr[i].y, L[i-1]);
        }

        R = new int[n]; //i~n까지 x2최소값
        R[n-1] = arr[n-1].y;
        for (int i = n-2; i >= 0 ; i--) {
            R[i] = Math.min(R[i+1],arr[i].y);
        }

        for (int i = 0; i < n; i++) {
            //왼쪽 겹치기
            if (i > 0 && L[i-1] >= arr[i].y)
                continue;

            if (i < n-1 && R[i+1] <= arr[i].y)
                continue;

            ans++;
        }

        System.out.println(ans);


    }
    //블투1, 털2
    static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p) {
            return this.x - p.x;
        }
    }
}


