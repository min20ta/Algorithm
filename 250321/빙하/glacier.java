
import java.util.*;
import java.io.*;


public class Main {

    static int[][]arr;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;

    static int max = Integer.MIN_VALUE;
    static int count = 0;




    static int ans = 0;
    static boolean[][] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static Queue<pair> q = new LinkedList<>();
    static int meltCounts = 0;
    static int t = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

            //바깥 = 0 물 1= 빙하
            // 1초마다 물닿은 빙하 녹음. but 물의 상하좌우 빙하면 못녹임
            //답: 빙하전체 녹는 시간, 마지막 녹는 크기
            visit = new boolean[n][m];
            for (int j = 0; j < m; j++) {
                visit[0][j] = true;
                visit[n-1][j] = true;
            }
            for (int j = 0; j < n; j++) {
                visit[j][0] = true;
                visit[j][m-1] = true;
            }

            int x = 1; int y = 1;

            while(!checkAllMelt()) {
                meltCounts = 0;
                t++;
                outSideMelt(x++,y++);
                //System.out.println("1: "+ meltCounts);
                bfs();
                //System.out.println("2: "+ meltCounts);
                list.add(meltCounts);

            }


            System.out.println(t + " "+ list.get(list.size()-1));





    }
    static boolean checkAllMelt() {
        int allMeltCounts = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    allMeltCounts++;
            }
        }
        if (allMeltCounts == n*m)
            return true;
        else
            return false;
    }

    static void outSideMelt(int x, int y) {
        y--;
        int row = x; int col = y+1;
        for (int i = 0; i < 4; i++) {

            while (true) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(nx >= row && nx < n-row && ny >= col && ny < m-col)) {
//                    if (i == 0) {x = row; y = m-1-col;}
//                    if (i == 1) {x = n-1-row; y = m-1-col;}
//                    if (i == 2) {x = n-1-row; y = col;}
                    break;
                }

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (arr[nx][ny] == 0)
                        q.add(new pair(nx, ny));
                    else {
                        arr[nx][ny] = 0;
                        meltCounts++;
                        //System.out.println(meltCounts);
                      //  System.out.println(i+" "+nx+" "+ny);
                    }
                }
                x = nx; y = ny;
            }
        }


    }
    static void bfs() {

        while (!q.isEmpty()) {

            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >=0 && ny < m) {
                    if (!visit[nx][ny]) {
                        visit[nx][ny] = true;
                        if (arr[nx][ny] == 0){
                            q.add(new pair(nx, ny));
                        }else {
                            arr[nx][ny] = 0;
                            meltCounts++;
                        }
                    }
                }
            }
        }
    }

  static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
  }
}