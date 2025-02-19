import java.util.*;
import java.io.*;


public class Main {
    static pair[][] map;
    static pair[] num;
    static pair[] display;
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
    static ArrayList<Integer> bombList = new ArrayList<>();
    static Queue<pair> q = new LinkedList<>();
    static int [][] duplicateList;
    static boolean[][] visit;
    static ArrayList<pair> grid = new ArrayList<>();
    static ArrayList<pair> temp = new ArrayList<>();
    static ArrayList<pair> temp2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            duplicateList = new int[4001][4001];
            time = 0;
            lastTime = -1;
            grid = new ArrayList<>();
            temp = new ArrayList<>();

            for (int[] i : duplicateList)
                Arrays.fill(i,-1);

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                int dir = 0;
                if (d == 'L') dir = 0;
                else if (d == 'D') dir = 1;
                else if (d == 'U') dir = 2;
                else if (d == 'R') dir = 3;

                r *= 2; c *= 2;
                r += 2000; c += 2000;
                grid.add(new pair(r,c, dir, w, i));
            }

            for (int i = 0; i <= 2 * 2000; i++) {
                move();
            }

            System.out.println(lastTime);


        }


    }


    static void move() {

        time++;

        for (int i = 0; i < grid.size(); i++) {

            int x = grid.get(i).x;
            int y = grid.get(i).y;
            int d = grid.get(i).d;
            int w = grid.get(i).w;
            int num = grid.get(i).num;

            int nx = x + dx[d] ;
            int ny = y + dy[d];

            if (!(nx >= 0 && nx <= 4000 && ny >= 0 && ny <= 4000))
                continue;

            int index = duplicateList[nx][ny];

            if (index == -1) {
                temp.add(new pair(nx, ny, d, w, num));
                duplicateList[nx][ny] = temp.size()-1;

            }else {
                //바로바로 충돌해결해야함

                int w1 = temp.get(index).w;
                int n1 = temp.get(index).num;

                if (w1 > w) temp.set(index,temp.get(index));
                else if (w1 < w) temp.set(index,new pair(nx, ny, d, w, num));
                else if (w1 == w && n1 > num) temp.set(index,temp.get(index));
                else temp.set(index,new pair(nx, ny, d, w, num));
                lastTime = time;


            }


        }

        grid = (ArrayList<pair>) temp.clone();
        for (int i = 0; i < temp.size(); i++) {
            int x = temp.get(i).x;
            int y = temp.get(i).y;
            duplicateList[x][y] = -1;
        }
            
        temp = new ArrayList<>();
    }




    static class pair {
        int x;
        int y;
        int d;
        int w;
        int num;

        pair(int x, int y, int d, int w, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.w = w;
            this.num = num;
        }


    }
}


