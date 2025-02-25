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
    static int t;
    static int lastTime = 0 ;
    static int ansSum;
    static int ansW;
    static int x = 0;
    static int y = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new pair(x,y));
        }

        for (int i = 0; i < m; i++) {
            pair p = pq.poll();
            int x = p.x +2;
            int y = p.y +2;

            pq.add(new pair(x,y));
    }

        pair p = pq.poll();
        System.out.println(p.x+" "+p.y);
    }

    static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p) {
            if (this.x+this.y == (p.x+p.y))
                return this.x - p.x;
            if (this.x == p.x)
                return this.y - p.y;
            return this.x+this.y - (p.x+p.y);
        }
    }
}


