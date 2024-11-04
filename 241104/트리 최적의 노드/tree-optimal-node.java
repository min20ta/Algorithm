import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean isTree = true;
    static int[] dist;
    static int longest;
    static int longestV = 1;

    static int[] arr;
    static boolean[] visit;
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

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }


        visit = new boolean[n + 1];
        dist = new int[n + 1];

        visit[1] = true;
        dist[1] = 0;
        longest = 0;
        dfs(1, 0);

        visit = new boolean[n + 1];
        dist = new int[n + 1];
        visit[longestV] = true;
        dist[longestV] = 0;
        longest = 0;
        dfs(longestV, 0);



        System.out.println((longest+1)/2);

    }

    //1-3-5
    //-2-4
    static void dfs(int node, int distance) {
        for (int next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                dist[next] = distance + 1;
                if (dist[next] > longest) {
                    longest = Math.max(longest, dist[next]);
                    longestV = next;
                }
                dfs(next, dist[next]);
            }
        }
    }
}