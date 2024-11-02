import java.util.*;
import java.io.*;




public class Main {
    static int n;


    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [] dist;
    static int length;

    // 부모노드로 올라올때 부모노드가 밑으로 내려가는게 아니라 옆에 같이 선다
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i <= n ; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        visit = new boolean[n+1];
        visit[1] = true;
        dist =new int[n+1];
        length = 0;
        dfs(1);


        if (length%2 == 1)
            System.out.println(1);
        else
            System.out.println(0);


    }



    //리프노드의 거리구하기
    static void dfs(int node) {

        boolean isLeaf = true;

        for (int next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                isLeaf = false;
                dist[next] = dist[node]+1;
                dfs(next);

            }
        }

        if (isLeaf)
            length += dist[node];
    }

}