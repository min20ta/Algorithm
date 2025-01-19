
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
    static ArrayList<pair> sPos = new ArrayList<>();
    static ArrayList<pair> stonePos = new ArrayList<>();
    static ArrayList<pair> selected = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static  Queue<pair> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];



        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (arr[i][j] == 1)
                    stonePos.add(new pair(i,j));
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sPos.add(new pair(r,c));
        }

        findMax(0,0);
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
                        queue.add(new pair(x,y));
                    }
                }
            }
        }

    }

    static void findMax(int idx, int cnt) {
      if (idx == stonePos.size()){
          if (cnt == m)
              max = Math.max(max,calc());
          return;
      }
      selected.add(stonePos.get(idx));
      findMax(idx+1,cnt+1);
      selected.remove(selected.size()-1);
      findMax(idx+1,cnt);

    }

    static int calc() {
        for (int i = 0; i < m; i++) {
            int x = selected.get(i).x;
            int y = selected.get(i).y;
            arr[x][y] = 0;
        }
        visit = new boolean[n+1][n+1];

        for (int i = 0; i < k; i++) {
                queue.add(sPos.get(i));
                visit[sPos.get(i).x][sPos.get(i).y] = true;
        }
        bfs();

        int sum = 0;
        for (int i = 1; i <= n  ; i++) {
            for (int j =1 ; j <= n ; j++) {
                if (visit[i][j])
                    sum++;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = selected.get(i).x;
            int y = selected.get(i).y;
            arr[x][y] = 1;
        }


        return sum;

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