import java.util.*;
import java.io.*;




public class Main {
    static int n;
    static int [] arr;

    static ArrayList<ArrayList<Pair>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [] dist;
    static int length;

    // 부모노드로 올라올때 부모노드가 밑으로 내려가는게 아니라 옆에 같이 선다
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());


            arrayList.get(a).add(new Pair(b,len));
            arrayList.get(b).add(new Pair(a,len));
        }

        dist = new int[n+1];
        visit = new boolean[n+1];
        visit[1] = true;
        dfs(1,0 );
        int longest = 0;
        int longestV = 0;


            for (int j = 0 ;j <= n ; j++) {
                if (dist[j] > longest) {
                    longest = dist[j];
                    longestV = j;
                }
            }

        dist = new int[n+1];
        visit = new boolean[n+1];
        visit[1] = true;
        dfs(longestV,0 );
        longest = 0;


        for (int j = 0 ;j <= n ; j++) {
            if (dist[j] > longest) {
                longest = dist[j];
            }
        }

        System.out.println(longest);


    }




        static class Pair{
        int num;
        int distance;

        Pair(int num , int distance) {
            this.num = num;
            this.distance = distance;
        }
    }


    static void dfs(int node, int distance) {

        for (Pair next : arrayList.get(node)) {
            if (!visit[next.num]) {
                visit[next.num] = true;
                dist[next.num] = distance + next.distance;
                dfs(next.num, dist[next.num]);
            }

        }
    }

}