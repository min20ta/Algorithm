
import java.util.*;
import java.io.*;


public class Main {

    static int [][] arr;
    static boolean [][] visit ;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int n;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }


        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        while(k-- > 0){
            visit = new boolean[n + 1][n + 1];
            ans =bfs(r,c, arr[r][c]);

            if (ans != Integer.MIN_VALUE) {
                loop:
                for (int i = 1; i <= n  ; i++) {
                    for (int j = 1; j <= n  ; j++) {
                        if (arr[i][j] == ans && visit[i][j] ){
                            r = i;
                            c = j;
                            break loop;
                        }
                    }
                }

            }
        }

        System.out.println(r + " "+ c);


    }
    static int bfs(int r, int c, int num) {
        visit[r][c] = true;
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(r,c));
        int max =Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x >= 1 && x <= n && y >= 1 && y <= n) {
                    if (!visit[x][y] && arr[x][y] < num ) {
                        visit[x][y] = true;
                        max = Math.max(max, arr[x][y]);
                        queue.add(new pair(x,y));
                    }
                }
            }
        }
        return max;

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