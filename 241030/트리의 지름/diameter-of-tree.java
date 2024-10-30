import java.sql.SQLOutput;
import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [][] lenArray ;
    static int line;
    static int [] lineArray;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        lenArray = new int[n+1][100001];

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);

            lenArray[a][b] = len;
            lenArray[b][a] = len;
        }

        lineArray = new int[n+1];

        for (int i = 1 ; i <= n ; i++) {
            visit = new boolean[n+1];
            visit[i] = true;
            line = 0;
            dfs(i);
            lineArray[i] = line;

        }

        Arrays.sort(lineArray);
        for (int a : lineArray)
            System.out.println(a);
        System.out.println(lineArray[n]);

    }

    static void dfs(int node) {

        for (int next: arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                line += lenArray[node][next];
                dfs(next);
            }
        }
    }

}