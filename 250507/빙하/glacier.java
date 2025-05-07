


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int t;
    static int ans;
    static int [][] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        tempArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];
            }
        }

        //밖은 항상 물
        //1 = 빙하, 0= 물
        //빙하 : 1초마다 물닿아있는 부분 동시 녹음
            //빙하로 둘러싸여있는(상하좌우) 물은 못녹임
        //시간, 마지막 녹은 크기


        //큐에 넣을거 : 물, 빙하

        t = 0;
        visit = new boolean[n][m];
        visit[0][0] = true;
        q.add(new pair(0,0));
        list.add(1); //맨 앞 임의
        while (list.get(list.size()-1) > 0) {
            nextQ = new LinkedList<>();
            bfs();
        }

        System.out.println(t-1+" "+ list.get(list.size()-2));


    }
    static void bfs() {

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visit[nx][ny]) {
                        visit[nx][ny] =true;

                        if (arr[nx][ny] == 0)
                            q.add(new pair(nx, ny));
                        else { //다음 녹일 물, 그래프 바꿔줘야함
                            nextQ.add(new pair(nx,ny));
                            tempArr[nx][ny] = 0;
                        }
                    }
                }
            }
        }

        t++;
        list.add(nextQ.size());
        q = new LinkedList<>(nextQ);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = tempArr[i][j];
            }
        }
    }

    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}



