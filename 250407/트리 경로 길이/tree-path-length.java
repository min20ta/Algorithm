
import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Integer>[][] arr ;
    static int[][] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0,-1,-1,1,1};
    static int[] dy = {-1, 0,0, 1,-1,1,1,-1};
    static int n;
    static int m;
    static int q;
    static int x;
    static int y;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        parent = new int[18][n+1];
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

        for (int h = 1; h <= 17 ; h++) {
            for (int i = 1; i <= n ; i++) {
                parent[h][i] = parent[h-1][parent[h-1][i]];
            }
        }

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
                parent[0][next] = node;
                depth[next] = depth[node]+1;
                tree(next);
            }
        }
    }



    static int findLength(int a, int b) {
        //공통조상구해서, 각 공통조상까지 거리합 -1
        int curA  = a; int curB = b;
        if (depth[a] < depth[b]){ //a를 더 크게
            int temp = a;
            a = b;
            b = temp;
        }


        for (int h = 17; h >= 0 ; h--) {
            if (depth[a] - depth[b] >= (1<<h))
                a = parent[h][a];
        }
        //일치해지기 직전
        int ancestor = a;
        if (a != b) {
            for (int h = 17; h >= 0; h--) {
                if (parent[h][a] != parent[h][b]) {
                    a = parent[h][a];
                    b = parent[h][b];
                }
            }
            ancestor = parent[0][a];
        }


        int ancesterDepth = depth[ancestor];
        int len1 = depth[curA] - ancesterDepth +1;
        int len2 = depth[curB] - ancesterDepth +1;

        int ans = len1+len2-1;

        return ans;
    }

}


