
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int edgeCount = 0;
    static int nodeCount = 0;
    static boolean [] finish;
    static int [] leftArr;
    static int [] rightArr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int subMax = Integer.MIN_VALUE;
    static Set<Integer>set = new HashSet<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        leftArr = new int[26];
        rightArr = new int[26];

        for (int i = 0; i < n; i++) {
            leftArr[i] = rightArr[i] = -1;
        }
        //리프노드까지 자식 -1로 있어야함
        //인덱스, 값 전부 정수여야 재귀가능
        

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.')
                leftArr[x-'A'] = left - 'A';
            if (right != '.')
                rightArr[x-'A'] = right - 'A';
        }



        preOrder(0);
        System.out.println();

        inOrder(0);
        System.out.println();

        postOrder(0);
        System.out.println();




    }


    static void preOrder(int x) {
        //종료조건을 넣어야함
        if (x==-1)
            return;
        System.out.println((char)(x+'A'));
        preOrder(leftArr[x]);
        preOrder(rightArr[x]);
    }

    static void inOrder(int x) {
        //종료조건을 넣어야함
        if (x==-1)
            return;
      
        preOrder(leftArr[x]);
        System.out.println((char)(x+'A'));
        preOrder(rightArr[x]);
    }


    static void postOrder(int x) {
        //종료조건을 넣어야함
        if (x==-1)
            return;
        preOrder(leftArr[x]);
        preOrder(rightArr[x]);
        System.out.println((char)(x+'A'));
    }



}








