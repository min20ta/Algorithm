import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [] dist;
    static int longestV =Integer.MIN_VALUE;
    static int [][] lenArray ;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        lenArray = new int[n + 1][100001];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);

            lenArray[a][b] = len;
            lenArray[b][a] = len;
        }

        visit = new boolean[n+1];
        dist = new int[n+1];

        //가장 멀리있는 정점정보찾기
       visit[1] = true;
       dist[1] = 0;
       dfs(1,0);

       int longestDist = Integer.MIN_VALUE;
       for (int i = 1; i <= n ; i++) {
           if (dist[i]> longestDist){
               longestDist = dist[i];
               longestV = i;
           }
       }


        visit = new boolean[n+1];
        dist = new int[n+1];
        visit[longestV] = true;
        dist[longestV] = 0;
       dfs(longestV,0);

        longestDist = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            if (dist[i]> longestDist){
                longestDist = dist[i];
                longestV = i;
            }
        }

        System.out.println(longestDist);

    }
    static void dfs(int node, int totalDistance) {

        for (int next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                dist[next] = totalDistance+ lenArray[next][node];
                dfs(next,dist[next]);
            }
        }
    }

}