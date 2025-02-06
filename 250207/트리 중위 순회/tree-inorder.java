
import java.util.*;
import java.io.*;


public class Main {

    static int k;
    static int idx = 1;
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
        k = Integer.parseInt(st.nextToken());

        //리프노드까지 자식 -1로 있어야함
        //인덱스, 값 전부 정수여야 재귀가능
        nodeCount = (int)Math.pow(2,k)-1;
        arr = new int[nodeCount+1];
        tree = new int[nodeCount+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeCount ; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }



       inOrder(1);
        for (int i = 1 ; i <= k ; i++) {
            for (int j = (1<<(i-1)); j <=(1<< i)-1; j++) {
                System.out.print(tree[j]+" ");
            }
            System.out.println();
        }

    }

//왼 중 오 순으로 접근한게 중위순회결과 print에서
// arr로만 바뀐것 일반배열에 저장

    static void inOrder(int x) {

        if (x > nodeCount)
            return;

        inOrder(x*2);
        tree[x] = arr[idx++];
        inOrder(x*2+1);




    }



}









