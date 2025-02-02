
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int k;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static ArrayList<Integer>[] tree;
    static int[] arr;
    static int[] parentArr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> goMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        arr = new int[n];
        parentArr = new int[n];

        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;

            if (a == k)
                findingNode = a; //찾고자하는 노드의 인덱스
        }

        int parent = -1;
        for (int i = 1; i <n ; i++) {
            if (arr[i-1]+1 < arr[i])
                parent++;

            parentArr[i] = parent;
        }

        for (int i = 0; i < n; i++) {
            if (parentArr[i]!= parentArr[findingNode] 
                    && parentArr[parentArr[i]] == parentArr[parentArr[findingNode]])
                ans++;
        }


        System.out.println(ans);

    }





        }




