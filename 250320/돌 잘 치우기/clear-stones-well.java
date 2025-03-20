
import java.util.*;
import java.io.*;


public class Main {

    static int[][]arr;
    static int[][]copyArr;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;

    static int max = Integer.MIN_VALUE;
    static int count = 0;



    static int[] depth = new int[50001];
    static pair[] rockArr;

    static int ans = 0;
    static boolean[][] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<pair> rockList = new ArrayList<>();
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> copyQ = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        copyArr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    rockList.add(new pair(i,j));
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            q.add(new pair(r,c));
        }


        //1=돌, m개 돌 치움. k 시작점 상하좌우
        // 답: 도달가능한 칸수

        //m개 조합으로 뽑기 -> 0으로 바꿈
        // 큐에 시작점 넣어서 이동칸 개수 구하기

        getMRock(0,0);
        System.out.println(max);
    }

    static void getMRock(int index, int cur) {

        if (index == m){
            bfs();
            max = Math.max(max, count);
            return;
        }

        for (int i = cur; i < rockList.size(); i++) {
            list.add(i);
            getMRock(index+1, i);
            list.remove(list.size()-1);
        }
    }

    static void changeToZero() {
        for (int i = 0; i < list.size(); i++) {
            pair p = rockList.get(list.get(i));
            int x = p.x;
            int y = p.y;

            copyArr[x][y] = 0;

        }
    }

    static void bfs() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        changeToZero();
        copyQ = new LinkedList<>(q);
        visit = new boolean[n+1][n+1];
        count = 0;

        while (!copyQ.isEmpty()) {
            pair p = copyQ.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    if (!visit[nx][ny] && copyArr[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        count++;
                        copyQ.add(new pair(nx, ny));
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