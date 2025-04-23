
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static int [] p;
    static int [] s;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<pair>> tree = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n ; i++) {
            tree.add(new ArrayList<>());
        }


        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            tree.get(a).add(new pair(b,val));
            tree.get(b).add(new pair(a,val));
        }

        visit = new boolean[n+1];
        depth = new int[n+1];
        parent = new int[18][n+1];
        visit[1] = true;
        depth[1] = 1;
        makeTree(1);
        makeParentPath();

        q = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];
        visit[1] = true;
        val = new int[n+1];
        getValue(1);

        //공통노드구해서, 각 노드~공통 가중치 합들
        //root~a + root~b - root~p
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int p = findAncestor(a,b);
            int ans = val[a] + val[b] - 2*val[p];

            System.out.println(ans);
        }
    }

    static void makeTree(int node) {
        for (pair next : tree.get(node)) {
            if (!visit[next.x]) {
                visit[next.x] = true;
                depth[next.x] = depth[node] + 1;
                parent[0][next.x] = node;
                makeTree(next.x);
            }
        }
    }
    
    static void makeParentPath() {
        for (int h = 1; h <=17 ; h++) {
            for (int i = 1; i <= n; i++) {
                parent[h][i] = parent[h-1][parent[h-1][i]];
            }
        }
    }

    static int findAncestor(int a, int b) {

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int h = 17; h >= 0 ; h--) {  //두 노드의 높이를 맞춰줌
            if (depth[a] - depth[b] >= (1<<h)) {
                a = parent[h][a];
            }
        }

        if (a==b){
            return a;
        }

        for (int h = 17; h >=0 ; h--) {
            if (parent[h][a] != parent[h][b]) {
                a = parent[h][a];
                b = parent[h][b];
            }
        }

        return parent[0][a];
    }

    static void getValue(int p) {
        for (pair next : tree.get(p)) {
            if (!visit[next.x]){
                visit[next.x] = true;
                val[next.x] = val[p] + next.len;
                getValue(next.x);
            }
        }
    }
    static class pair{
        int x;
        int len;

        pair(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }

}



