import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] dice = {{0,5,0},{4,6,3},{0,2,0},{0,1,0}};
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1,};
    static int[] dy = {-1, 0, 1, 0};
    static char [] dir ;
    static int n;
    static int m;
    static int r;
    static int c;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair> list = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); r--;
        c = Integer.parseInt(st.nextToken()); c--;



        map = new int[n][n];


        bomb(r,c);
        System.out.println(count());


        }

    static void bomb(int r, int c) {

        map[r][c] = 1;
//        q.add(new pair(r,c,1));
        list.add(new pair(r,c,1));

//        while(!q.isEmpty()) {
//
//            pair p  = q.poll();
//            if (p.t == m+1)
//              continue;
//            int x = p.x;
//            int y = p.y;
//            int t = p.t;
//
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i]*(1<<(t-1));
//                int ny = y + dy[i]*(1<<(t-1));
//                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
//                    map[nx][ny] = 1;
//                    //System.out.println(nx +" "+ ny);
//                }
//            }
//
//            addQ(t+1);
//        }

        loop:
        while(true) {

            int size = list.size();

            for (int k = 0; k < size ; k++) {
                pair p = list.get(k);

                if (p.t == m+1)
                    break loop;

                int x = p.x;
                int y = p.y;
                int t = p.t;
                list2.add(new pair(x,y,t+1));

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i]*(1<<(t-1));
                    int ny = y + dy[i]*(1<<(t-1));
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        map[nx][ny] = 1;
                       // System.out.println(nx+" "+ny);
                        list2.add(new pair(nx, ny, t+1));
                    }
                }
            }

            list = new ArrayList<>(list2);
            list2.clear();
        }
        }

        
    static int count(){

        int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1)
                        sum++;
                }
            }
            return sum;
        }

    static class pair {
        int x;
        int y;
        int t;

        pair(int x, int y, int t) {
            this.x =x;
            this.y = y;
            this.t = t;
        }
        }
}

