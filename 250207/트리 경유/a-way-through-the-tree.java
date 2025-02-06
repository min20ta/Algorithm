
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[] visit;
    static int edgeCount = 0;
    static int nodeCount = 0;
    static boolean [] finish;
    static int [] tree;
    static int [] rightArr;
    static int [] arr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int subMax = Integer.MIN_VALUE;
    static Set<Integer>set = new HashSet<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());


        arr = new int[q+1];
        tree = new int[2*n];
//        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q ; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        int idx = 0;

        //트리 만들기
        int count = 0;

        for (int i = 1; i <= n ; i++) {
            tree[i] = i;
        }

        while (q-- > 0) {

            //트리 탐색
            //도착한거에 -1처리
            //같은 라인은 괜찮. 부모라인확인필요
            int find = arr[idx++];
            int parent = find/2;
            boolean ans = true;
            int block = 0;

//            System.out.println(find+" "+ parent);
            while(parent > 1) {
                if (tree[parent] == -1){
                    ans = false;
                    block = parent;
                }
                parent /= 2;
            }

            if (ans &&tree[find] == -1)
                System.out.println(find);
            else if (ans){
                System.out.println(0);
                tree[find] = -1;
            }else
                System.out.println(block);


        }




    }






}














