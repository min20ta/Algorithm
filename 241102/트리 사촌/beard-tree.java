import java.util.*;
import java.io.*;




public class Main {
    static int n;
    static int k;
    static int [] arr;
    static int [] tree;
    static int ans= 0;


    static boolean [] visit;
    static int [] dist;
    static int length;

    // 부모노드로 올라올때 부모노드가 밑으로 내려가는게 아니라 옆에 같이 선다
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        int find = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == k)
                find = i;
        }

        int parent = 0;
        tree = new int[n+1];
        for (int i = 2 ; i <= n ; i++) {
            if (arr[i] > arr[i-1]+1) {
                parent++;
            }
            tree[i] = parent;
        }

        //사촌수 구하기
        //부모가 형제, 다른 부모
        //tree 0,1은 루트다음으로 건너뛴것
        // 
        for (int i = 2 ; i <= n ;i++) {
            // if(tree[tree[i]] == 0 || tree[tree[find]] == 0)
            //     continue;
            if (tree[tree[i]] == tree[tree[find]] && tree[i] != tree[find])
                ans++;
        }


        System.out.println(ans);

    }

}