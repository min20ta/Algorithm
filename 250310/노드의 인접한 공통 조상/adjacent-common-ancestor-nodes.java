
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[10001];
    static int[] parent = new int[10001];
    static int[][] dp;
    static boolean [] visit = new boolean[10001];
    static int root;

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        Arrays.fill(parent,-1);

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
            parent[b] = a;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans1 = Integer.parseInt(st.nextToken());
        int ans2 = Integer.parseInt(st.nextToken());

        //루트노드 구해야하나?
        // 모든 정점, 부모노드 여부
        findRoot();
        depth[root] = 1;
        visit[root] = true;
        findDepth(root);
        System.out.println(findCommonAncestor(ans1, ans2));

    }
    static void findRoot() {
        for (int i = 1; i <= n ; i++) {
            if (parent[i] == -1)
                root = i;
        }
    }

    static void findDepth(int node) {

        //depth 비교필요
        //부모 depth로 변환
        for (int nextNode : tree.get(node)) {
            if (!visit[nextNode]) {
                visit[nextNode] = true;
                depth[nextNode] = depth[node] + 1;
                findDepth(nextNode);
            }
        }
    }

    static int findCommonAncestor(int node1, int node2) {

        while (depth[node1] != depth[node2]){
            if (depth[node1] > depth[node2])
                node1 = parent[node1];
            else
                node2 = parent[node2];
        }

        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        return node1;
    }
}