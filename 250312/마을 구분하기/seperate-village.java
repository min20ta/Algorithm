import java.util.*;
import java.io.*;


public class Main {

    static pair [] xArr;
    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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
    static int peopleNum;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][n];
        int groupNum = 0;
        ArrayList<Integer>list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    visit[i][j] = true;
                    peopleNum = 1;
                    dfs(i, j);
                    groupNum++;
                    list.add(peopleNum);
                }
            }
        }

        //마을개수, 사람수

        System.out.println(groupNum);
        Collections.sort(list);
        for (int a : list) {
            System.out.println(a);
        }



    }
    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visit[nx][ny] && arr[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    peopleNum++;
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