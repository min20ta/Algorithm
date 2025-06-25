

import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int n ;
    static int m;
    static int k ;
    static int[] arr;
    static int[] orderArr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[][] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;

    static HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    static Deque<String> stack = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n ; i++) { // 그룹 초기화. 일단 모두 다른 그룹에 있음
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }

        orderArr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            orderArr[i] = Integer.parseInt(st.nextToken());
        }

        //같은 집합인지 확인

        boolean flag = true;
        for (int i = 0; i < k-1; i++) {
            if (find(orderArr[i]) != find(orderArr[i+1])) {
                System.out.println(0);
                flag = false;
                break;
            }
        }

        if (flag)
            System.out.println(1);

    }
    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        arr[x] = y;
    }

    static int find(int x) {
        if (arr[x] == x)
            return x;

        return arr[x] = find(arr[x]);
    }


}




