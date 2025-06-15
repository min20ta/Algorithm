


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int n ;
    static int m;
    static int k ;
    static int[][] arr;
    static int[][] dirArr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[][] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        dirArr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dirArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); r--;
        int c = Integer.parseInt(st.nextToken()); c--;

        findMax(r,c);
        System.out.println(max);







    }
    static void findMax(int r, int c) {

        q.add(new pair(r,c,0));

        while (!q.isEmpty()) {

            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int count = p.count;
            int dir = dirArr[x][y]; dir--;
            max = Math.max(max, count);

            for (int i = 1; i <= n ; i++) {
                int nx = x + dx[dir]*i;
                int ny = y + dy[dir]*i;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] > arr[x][y]) {
                        //System.out.println(x+" "+y+" " +nx+" "+ ny);
                        q.add(new pair(nx,ny,count+1));
                    }
                }
            }
        }



    }
    static class pair{
        int x;
        int y;
        int count;

        pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }



}
