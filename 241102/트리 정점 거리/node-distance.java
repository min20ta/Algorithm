import java.util.*;
import java.io.*;




public class Main {
    static int n;
    static int m;

    static ArrayList<ArrayList<Pair>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int length;
    static int [][] answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i <= n ; i++) {
            arrayList.add(new ArrayList<Pair>());
        }

        for (int i = 0 ; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new Pair(b,d));
            arrayList.get(b).add(new Pair(a,d));
        }

        answer = new int[m][2];
        visit = new boolean[n+1];
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

//            answer[i][0] = start;
//            answer[i][1] = end;

            visit = new boolean[n+1];
            visit[start] = true;
            length = 0;
            dfs(start, end,0);
            System.out.println(length);
        }







    }
    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }


    static void dfs(int node, int end, int distance) {

        for (Pair next : arrayList.get(node)) {
            if (!visit[next.node]){
                visit[next.node] = true;

                if (next.node == end) {
                    length = distance + next.distance;
                    return;
                }else
                    dfs(next.node, end, distance+next.distance);
            }
        }
    }


}