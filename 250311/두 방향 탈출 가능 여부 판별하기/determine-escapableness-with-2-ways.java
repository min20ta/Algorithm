
import java.util.*;
import java.io.*;


public class Main {

    static pair [] xArr;
    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0};
    static int[] dy = {1, 0, -1};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[][] parent ;
    static int[][] arr;
    static int[][] ans;
    static boolean [][] visit;
    static int root;
    static int count;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        visit[0][0] = true;
        dfs(0,0);
        if (ans[n-1][m-1] == 1)
            System.out.println(1);
        else
            System.out.println(0);




    }
    static void dfs(int x, int y) {

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visit[nx][ny] && arr[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    ans[nx][ny] = 1;
                    dfs(nx,ny);
                }
            }
        }
    }

    static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
}