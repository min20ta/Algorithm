import java.util.*;
import java.io.*;


public class Main {
    static pair[][] map;
    static pair[] num;
    static pair[] display;
    static int[][] dir;
    static int[][] dir2;
    static int idx = 0;
    static int[] dx = {0,1,-1,0};
    static int[] dy = {-1,0,0,1};
    static int n;
    static int m;
    static int t;
    static int k;
    static int x = 0;
    static int y = 0;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair>[][] list;
    static ArrayList<pair> list2 = new ArrayList<>();
    static ArrayList<int[][]> dirList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static pair Blank = new pair(-1,-1,-1,-1,-1);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new pair[m];
        list = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;
            char d = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());

            int dir = 0;
            if (d == 'L') dir = 0;
            else if (d == 'D') dir = 1;
            else if (d == 'U') dir = 2;
            else if (d == 'R') dir = 3;

            num[i] = new pair(r,c,dir,v,i);
            list[r][c].add(new pair(r,c,dir,v,i));
        }

        while (t-->0) {
            move();
            bomb();
        }

        System.out.println(count());



    }

    static void move() {
        for (int i = 0; i < m; i++) {
            pair p = num[i];
            int x = p.x; int y = p.y; int d = p.d; int v = p.v;

            int nx = x + dx[d]*v;
            int ny = y + dy[d]*v;
           // System.out.println(nx +" "+ ny);
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                d = 3 - d;
                if (nx <0) nx = Math.abs(nx);
                else if (nx >= n) nx = 2*n -nx - 2;

                if (ny < 0) ny = Math.abs(ny);
                else if (ny >= n) ny = 2*n -ny - 2;

            }

           // System.out.println(x+" "+ y+" "+ nx+" "+ny);
            list[x][y].removeIf(q -> q.num == p.num);
            list[nx][ny].add(new pair(nx,ny,d,v,p.num));
           // System.out.println(list[nx][ny].size());
        }

    }

    static void bomb() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int size = list[i][j].size();
                if (size >= k) {
                    Collections.sort(list[i][j]);
                    int erase = size - k;
                    while (erase -- > 0)
                        list[i][j].remove(list[i][j].size()-1);
                }
            }
        }
    }

    static int count() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if (list[i][j].get(0) != Blank)
                    sum+=list[i][j].size();
            }
        }
        return sum;
    }





    static class pair implements Comparable<pair> {
        int x;
        int y;
        int d;
        int v;
        int num;

        pair(int x, int y, int d, int v, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.v = v;
            this.num = num;
        }

        @Override
        public int compareTo(pair p) {
            if (p.v == this.v)
                return p.num - this.num;
            return p.v - this.v;
        }
    }
}


