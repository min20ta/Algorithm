
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [] finish;
    static int [][] arr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int ans = Integer.MIN_VALUE;

  




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }


        //중심좌표하나 잡고 모든 k적용. => 중복발생

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) { //해당죄표에서 k=0,1,
                    visit = new boolean[n][n];
                    int goldCount = mineGold(k, i, j);
                    if (notLose(k, goldCount))
                        ans = Math.max(ans, goldCount);

                }
            }
        }

        System.out.println(ans);
        }

    static int mineGold(int k , int x, int y) {
        Queue<pair> q = new LinkedList<>();
        Queue<pair> nextQ = new LinkedList<>();
        q.add(new pair(x,y,0));
        visit[x][y] = true;

        int gold = 0;
      

        while (!q.isEmpty()) {
            pair p = q.poll();
            if (arr[p.x][p.y] == 1)
                gold++;
            if (p.d == k)
                continue;



            for (int j = 0; j < 4; j++) {
                int nextX = p.x + dx[j];
                int nextY = p.y + dy[j];

                if (nextX >= 0 && nextY >= 0 && nextY < n && nextX < n
                && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    q.add(new pair(nextX, nextY, p.d+1));

                }
            }
          

        }
        return gold;

    }

    static boolean notLose(int k, int gold) {
        int square = k*k + (k+1)*(k+1);
        int goldMoney = gold * m;

        if (square < goldMoney)
            return true;
        return false;
    }


    static class pair {
        int x;
        int y;
        int d;

        pair(int x, int y, int d) {
            this.x =x;
            this.y = y;
            this.d = d;
        }
    }
}


