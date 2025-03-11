
import java.util.*;
import java.io.*;


public class Main {

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
    static boolean [] visit = new boolean[50001];
    static int root;

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        parent = new int[16][n+1];

        root = 1;
        depth[1] = 1;
        visit[root] = true;

        dfs(root);
        fillParent();

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans1 = Integer.parseInt(st.nextToken());
            int ans2 = Integer.parseInt(st.nextToken());

            if (ans1 > ans2) System.out.println(findCommonAncestor(ans1,ans2));
            else System.out.println(findCommonAncestor(ans2,ans1));


        }



    }
    static void dfs(int node) {
        for (int next : tree.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                depth[next] = depth[node] + 1;
                parent[0][next] = node; //루트알면 바로가능?
                dfs(next);
            }
        }
    }

    static void fillParent() {
        for (int h = 1; h <= 16; h++) {
            for (int i = 1; i <= n ; i++) {
                parent[h][i] = parent[h-1][parent[h-1][i]];
            }
        }
    }

    static int findCommonAncestor(int a, int b) {
        for (int h = 16; h >=0 ; h--) {
            if (depth[a] - depth[b] >= (1<<h)){
                a= parent[h][a];
            }
        }

        if (a==b)
            return a;

        for (int h = 16; h >=0 ; h--) {
            if (parent[h][a] != parent[h][b]){
                a = parent[h][a];
                b = parent[h][b];
            }
        }

        return parent[0][a];
    }
}