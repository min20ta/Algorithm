
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
    static int[][] dp;
    static boolean [] visit = new boolean[10001];
    static int root;
    static int count;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visit[1] = true;
        dfs(1);
        System.out.println(count);



    }
    static void dfs(int node) {

        for (int next : graph.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                count++;
                dfs(next);
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