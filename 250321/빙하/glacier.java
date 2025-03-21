
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
    static Queue<pair> nextQ = new LinkedList<>();
    static int meltCounts = 0;
    static int t = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit= new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

            //바깥 = 0 물 1= 빙하
            // 1초마다 물닿은 빙하 녹음. but 물의 상하좌우 빙하면 못녹임
            //답: 빙하전체 녹는 시간, 마지막 녹는 크기

            q.add(new pair(0,0));
            visit[0][0] = true;

            while(true) {
                meltCounts = 0;
                nextQ.clear();
                bfs();
                if (meltCounts == 0)
                    break;
                else{
                    t++;
                    list.add(meltCounts);
                }
            }



            System.out.println(t + " "+ list.get(list.size()-1));





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
                        if (arr[nx][ny] == 0){ //물을 큐에 추가
                            q.add(new pair(nx, ny));
                        }else { //녹은 빙하는 다음 번 큐 대상
                            nextQ.add(new pair(nx,ny));
                            arr[nx][ny] = 0;
                            meltCounts++;
                        }
                    }
                }
            }
        }
        q = new LinkedList<>(nextQ);
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