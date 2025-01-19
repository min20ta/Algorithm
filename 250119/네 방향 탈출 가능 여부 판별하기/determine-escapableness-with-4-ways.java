
import java.util.*;
import java.io.*;


public class Main {

    static int [][] arr;
    static boolean [][] visit ;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        visit = new boolean[n][m];
        bfs();
        if (arr[n-1][m-1] == 2)
            System.out.println(1);
        else
            System.out.println(0);


    }
    static void bfs() {
        visit[0][0] = true;
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(0,0));

        while (!queue.isEmpty()) {
            pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (!visit[x][y] && arr[x][y] == 1) {
                        visit[x][y] = true;
                        arr[x][y] = 2;
                        queue.add(new pair(x,y));
                    }
                }
            }
        }
    }

    static class pair  {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}