import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean isTree = true;
    static int [] dist;
    static int longest;

    static int [] arr;
    static boolean [] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        // 가중치 1
        // 가장 먼 노드까지의 거리가 최소
        // 가장 먼 노드까지 거리

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        for (int i = 1 ; i <= n ; i++) {
            visit = new boolean[n+1];
            dist= new int[n+1];

            visit[i] = true;
            dist[i] = 0;
            longest = 0;
            dfs(i,0);
          

            min = Math.min(min, longest);
         }

        System.out.println(min);

    }

    static void dfs(int node, int distance) {
        for (int next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                dist[next] = distance+1;
                longest = Math.max(longest, dist[next]);
                dfs(next, dist[next]);
            }
        }
    }

}