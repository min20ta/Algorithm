import java.util.*;
import java.io.*;




public class Main {
    static int n;
    static int m;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int length;
    static int [][] answer;

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

        // 노드의 부모노드로 말 옮기기
        // 루트노드도착시 그노드 제거 . 루트노드는 1번

        // 더 이상 옮길말 없음+ 내 차례 = 패배
        // a가 승리할 수 있는지

        visit = new boolean[n+1];
        visit[1] = true;
        length = 0;
        dfs(1);
        length++;

        if (length%2 == 0)
            System.out.println(1);
        else
            System.out.println(0);


    }

    static void dfs(int node) {

        for (int next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                length++;
                dfs(next);

            }
        }
    }

}