import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean isTree = true;
    static int [] dist;
    static int root;

    static int [] arr;
    static int [] parent;
    static int [] deg;
    static boolean [] visit;
    static boolean [] used;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 루트노드 한개 정확히 존재
        // 모든 노드는 반드시 단 하나의 들어오는 간선존재
        // 루트 노드에서 정점까지 경로 유일
        // 트리인지 판별하자

        for (int i = 0 ; i <= 10000 ; i++) {
            arrayList.add(new ArrayList<>());
        }

        used = new boolean[10001];
        visit = new boolean[10001];
        deg = new int[10001];


        //단방향으로 입력받을 때
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //단방향으로 받기
            arrayList.get(a).add(b);

            used[a] = used[b] = true; // 어떤 노드가 들어오는지 파악
            deg[b]++; //들어오는 간선 수
        }

        for (int i = 0; i <= 10000; i++) {
            if (used[i] && deg[i] == 0) {  //루트제외 간선 1개씩
                if (root != 0)
                    isTree = false;
                root = i;
            }
        }

        if (root == 0) {
            isTree = false;
        }

        for (int i = 1 ; i <= 10000 ; i++) {
            if (used[i] && root != i && deg[i]!=1)
                isTree = false;
        }

        //루트정점으로부터 모든 정점을 갈 수 있는지
        if(isTree && root != 0) {
            visit[root] = true;
            dfs(root);
        }

        for (int i = 0; i <= 10000; i++) {
            if (used[i] && !visit[i])
                isTree = false;
        }


        if (isTree)
            System.out.println(1);
        else
            System.out.println(0);



        }
        static void dfs(int node) {
            for (int next : arrayList.get(node)) {
                visit[next] = true; //굳이 if조건안해도 될거같은데??
                dfs(next);
            }
        }



}