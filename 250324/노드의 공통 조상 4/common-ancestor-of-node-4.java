
import java.util.*;
import java.io.*;


public class Main {

    static int[] depth;
    static int[] parent;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int q;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visit = new boolean[n+1];
        parent = new int[n+1];
        depth = new int[n+1];
        visit[1] = true;
        depth[1] = 1;
        tree(1);

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //풀이
            System.out.println(findAncestor(a,b));


        }

    //루트 = 1
        // 조상 = 할머니까지


    }
    static void tree(int node) {

        for (int next : list.get(node)) {
            if (!visit[next]){
                visit[next] = true;
                parent[next] = node;
                depth[next] = depth[node]+1;
                tree(next);
            }
        }
    }

    static int findAncestor(int node1, int node2) {
        while (depth[node1] != depth[node2]) {
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