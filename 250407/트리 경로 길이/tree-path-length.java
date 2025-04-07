
import java.util.*;
import java.io.*;


public class Main {

    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int n;
    static int q;
    

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        visit = new boolean[n+1];
        depth = new int[n+1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        depth[1] = 1;
        visit[1] = true;
        tree(1);

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(findLength(a,b));
        }

        //n개 정점 . 루트1


    }

    static void tree(int node) {

        for(int next: tree.get(node)) {
            if (!visit[next]){
                visit[next] = true;
                parent[next] = node;
                depth[next] = depth[node]+1;
                tree(next);
            }
        }
    }


    static int findLength(int a, int b) {
        //공통조상구해서, 각 공통조상까지 거리합 -1
        int curA = a; int curB = b;

        while (depth[a] != depth[b]){
            if (depth[a] > depth[b])
                a = parent[a];
            else if (depth[a] < depth[b])
                b = parent[b];
        }

        while (a!=b) {
            a = parent[a];
            b = parent[b];
        }

        int ancesterDepth = depth[a];
        int len1 = depth[curA] - ancesterDepth +1;
        int len2 = depth[curB] - ancesterDepth +1;

        int ans = len1+len2-1;

        return ans;
    }

}


