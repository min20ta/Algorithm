import java.sql.SQLOutput;
import java.util.*;
import java.io.*;




public class Main {
    static int n;

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean [] isDeleted;
    static int [] dist;
    static int longestV =Integer.MIN_VALUE;
    static int ans;
    static int [][] lenArray ;

    static int [] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arrayList.add(new ArrayList<>());
        }

        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {

            int node = Integer.parseInt(st.nextToken());

            if (node == -1){
                root = i;
                continue;
            }

            arr[i] = node;
        }

        int deleteNode = Integer.parseInt(br.readLine());



        for (int i = 1 ; i < n ; i++) {
            arrayList.get(arr[i]).add(i);
        }


        isDeleted = new boolean[51];

        isDeleted[deleteNode] = true;

        dfs(root);






        // 51 - 1 - 3
        //        - 4
        //    - 2


        System.out.println(ans);
    }

    static void dfs(int node) {

        if (isDeleted[node])  //루트가 삭제
            return;

        boolean isLeaf = true;

        for (int next : arrayList.get(node)) {
            if (isDeleted[next])  //실제로 진짜 삭제하는게 아니라 스킵!
                continue;

            isLeaf = false;
            dfs(next);
        }

        if (isLeaf)
            ans++;
    }


}