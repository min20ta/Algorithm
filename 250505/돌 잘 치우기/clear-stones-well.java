

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
    static int k;
    static int ans;
    static int [][] arr;
    static int[][] tempArr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<pair> list = new ArrayList<>();
    static List<pair> rockList = new ArrayList<>();
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> tempQ = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        tempArr = new int[n][n];
        
        //m개 돌 치워 k시작점으로부터 상하좌우도달가능칸 수 최대
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];

                if (arr[i][j] == 1)
                    rockList.add(new pair(i,j));
            }
        }
        size = rockList.size();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;

            q.add(new pair(r,c));
            tempQ.add(new pair(r,c));
        }

        //돌고르기
        rock(0,0);

        System.out.println(max);



    }
    static void rock(int idx, int count) {
        if (count == m){
            visit = new boolean[n][n];
            max = Math.max(max, bfs());
            return;
        }

        if (idx == size)
            return;

        //ox

            list.add(rockList.get(idx));
            rock(idx+1, count+1);
            list.remove(list.size()-1);
            rock(idx+1, count);

    }
    
    static int bfs() {

        //돌없애기
        for (int i = 0; i < m; i++) {
            pair p = list.get(i);
            arr[p.x][p.y] = 0;
        }

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny] && arr[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        arr[nx][ny] = -1;
                        q.add(new pair(nx, ny));
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1)
                    count++;
            }
        }

        //복원
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tempArr[i][j];
            }
        }

        q = new LinkedList<>(tempQ);

        return count;

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



