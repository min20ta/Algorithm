
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;
    static boolean noUnder;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        parent = new int[n+1];
        visit = new boolean[n+1];
        visit[1] = true;
        depth = new int[n+1];
        depth[1] = 1;

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        findTree(1);

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

       //     System.out.println(parent[11]);
            System.out.println(findAncestor(a,b,c));
        }
    }


    static void findTree(int node) {

        for (int next : tree.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                parent[next] = node;
                depth[next] = depth[node] + 1;
                findTree(next);
            }
        }
    }

    static int findAncestor(int a, int b, int c) {
        // 같은 곳까지 올라와야함
        while (!(depth[a] == depth[b] && depth[b] == depth[c])) {
           // System.out.println(depth[a] +" "+ depth[b]+" "+ depth[c]);
            if (depth[a] >= depth[b] && depth[a] >= depth[c]) //a가 최고
                a = parent[a];
            else if (depth[b] >= depth[a] && depth[b] >= depth[c]) //b가 최고
                b = parent[b];
            else if (depth[c] >= depth[b] && depth[c] >= depth[a]) //c가 최고
                c = parent[c];
         }



        //가장 가까운 조상
        while (!(a == b && a == c)) {
             a = parent[a];
             b = parent[b];
             c = parent[c];

        }

        return a;
    }
}


