
import java.util.*;
import java.io.*;


public class Main {

    static int [][] arr;
    static int [][] arr2;
    static boolean [][] visit ;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int n;
    static int k;
    static int m;
    static ArrayList<pair> arrayList;
    static int max = Integer.MIN_VALUE;
    static  Queue<pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        arrayList = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.add(new pair(r,c));
        }

        //돌제거후 매번 bfs시행.
        //dfs를 같이 써야하나???

        dfs(0);
        System.out.println(max);

    }
    static void bfs() {

        while (!queue.isEmpty()) {
            pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x >= 1 && x <= n && y >= 1 && y <= n) {
                    if (!visit[x][y] && arr[x][y] == 0 ) {
                        visit[x][y] = true;
                        arr2[x][y] = 2;
                        queue.add(new pair(x,y));
                    }
                }
            }
        }

    }

    static void dfs(int depth) {
        if (depth == m) {
            arr2 = new int[n+1][n+1];
            visit = new boolean[n+1][n+1];
            
            for (int i = 0; i < k; i++) {
                pair p = arrayList.get(i);
                int r = p.x;
                int c = p.y;
                visit[r][c] = true;
                arr2[r][c] = 2;
                queue.add(new pair(r,c));
            }
            
            bfs();
            
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n ; j++) {
                    if (arr2[i][j] == 2)
                        sum++;
                }
            }

            max = Math.max(max, sum);

            return;
        }

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    dfs(depth+1);
                    arr[i][j] = 1;
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