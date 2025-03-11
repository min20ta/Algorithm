


import java.util.*;
import java.io.*;


public class Main {

    static pair [] xArr;
    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[][] parent ;
    static int[][] dp;
    static boolean [] visit = new boolean[10001];
    static int root;

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(br.readLine());

       xArr = new pair[n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            xArr[i] = new pair(a,b);
        }

        Arrays.sort(xArr, new Comparator<pair>() {
            @Override
            public int compare(pair p1, pair p2) {
                if (p1.x == p2.x)
                    return p1.y - p2.y;
                return p1.x - p2.x;
            }
        });

        //선분검사
        //100개
        int count = n;
        for (int i = 0; i < n-1; i++) {
            boolean check = false;

            for (int j = i+1; j <  n; j++) {

                pair p1 = xArr[i];
                pair p2 = xArr[j];

                if (p1.x <= p2.x && p2.y <= p1.y) {
                    count --;
                    check = true;
                }
            }
            if (check)
                count--;
        }
        System.out.println(count);
    }



    static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
}