
import org.w3c.dom.ls.LSOutput;

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
    static int[][] copyArr;
    static int[][] ans;
    static boolean [][] visit;
    static int root;
    static int peopleNum;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        //1~100
        //같은 숫자 인접블럭 4개칸이상 터짐
        //터지는 블럭수, 터지는 / 안터지는         최대블럭 크기
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        pair [] ans = new pair[100];
        int index = 0;


            visit = new boolean[n][n];
            int groupNum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        visit[i][j] = true;
                        peopleNum = 1;
                        dfs(i, j, arr[i][j]);

                        if (peopleNum >= 4)
                                groupNum++;
                        if (peopleNum > max)
                            max = peopleNum;
                    }
                }
            }



        System.out.println(groupNum+" "+ max);



    }

    static void dfs(int x, int y, int num) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visit[nx][ny] && arr[nx][ny] == num) {
                    visit[nx][ny] = true;
                    peopleNum++;
                    dfs(nx,ny, num);
                }
            }
        }
    }

    static class pair{
        int k;
        int group;

        pair(int k, int group) {
            this.k= k;
            this.group = group;
        }
    }
}