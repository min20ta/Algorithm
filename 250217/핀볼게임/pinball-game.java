import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] snake;
    static pair [] apple;
    static int [] dirNum;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1,};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static int k;
    static int t = 1;
    static int stop = 0;
    static int prev;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair> tailList = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        pair [] dir = {new pair(0,0,1,1), new pair(0,n-1,0,0),
                        new pair(n-1,0,3,1),new pair(0,0,2,0)};
        for (int i = 0; i < 4; i++) {
            pair p = dir[i];

            for (int j = 0; j < n; j++) {
                int x = p.x ;
                int y = p.y ;

                if (p.rowOrCol == 0)
                    x += j;
                else
                    y += j;

                t = 1;
                //System.out.println(p.d);
                time = pinBall(x,y,p.d);
               // System.out.println(x+ " "+ y +" "+ time);
                max = Math.max(max, time);
            }
        }

        System.out.println(max);




    }
    static int pinBall(int x, int y, int d) {

        next = d;
        while (true) {

            t++;
            int nx = x + dx[next];
            int ny = y + dy[next];
            //System.out.print("n "+x+" "+y+" "+next+" ");
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n))
                return t;

            if (map[nx][ny] == 0) {
                next = next;
            }else if (map[nx][ny]== 1) {
                if (next == 1) next = 0;
                else if (next == 2) next = 3;
                else if (next == 3) next = 2;
                else if (next == 0) next = 1;
            }else if (map[nx][ny] == 2){
                if (next == 0) next = 3;
                else if (next == 1) next = 2;
                else if (next == 2) next = 1;
                else if (next == 3) next = 0;
            }

            x = nx; y = ny;
            //System.out.println();
        }
    }

    static class pair {
        int x;
        int y;
        int d;
        int rowOrCol;

        pair(int x, int y,int d, int rowOrCol) {
            this.x =x;
            this.y = y;
            this.d = d;
            this.rowOrCol = rowOrCol;


        }
        }
}

