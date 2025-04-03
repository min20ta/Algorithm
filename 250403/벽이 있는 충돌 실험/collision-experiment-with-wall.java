
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static pair[][] infoArr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int t;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            q = new LinkedList<>();
            nextQ = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                x--;
                int y = Integer.parseInt(st.nextToken());
                y--;
                arr[x][y]++;

                char d = st.nextToken().charAt(0);

                int dir = 0;
                if (d == 'L') dir = 0;
                else if (d == 'D') dir = 1;
                else if (d == 'U') dir =2 ;
                else  dir = 3;

                nextQ.add(new pair(x, y, dir));
            }

            int time = 250;
            while (time-- > 0) {
                infoArr = new pair[n][n];
                roll();
            }

            System.out.println(countBall());
        }


    }

    static void roll() {

        q = new LinkedList<>(nextQ);
        nextQ = new LinkedList<>();

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = p.d;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                d = 3 - d;
                nx = x;
                ny = y;
            }

            arr[x][y]--;
            arr[nx][ny]++;
            infoArr[nx][ny] = new pair(nx, ny, d);

        }
        bomb();
    }

    static void bomb() {
        //System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print(arr[i][j]+" ");
                if (arr[i][j] >= 2)
                    arr[i][j] = 0;
                else if (arr[i][j] == 1) {
                    nextQ.add(new pair(i, j, infoArr[i][j].d));
                }
            }
            //System.out.println();
        }
    }

    static int countBall() {
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    static class pair {
        int x;
        int y;
        int d;

        pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

    }
}


