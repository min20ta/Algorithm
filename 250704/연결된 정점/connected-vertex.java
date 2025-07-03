


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
    static int[] num;
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


        arr = new int[n+1];
        num = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            arr[i] = i;
            num[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            if (c == 'x') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }else {
                int a = Integer.parseInt(st.nextToken());
                System.out.println(num[find(a)]);

            }
        }







    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);


        if(x != y) {
        arr[x] = y;
        num[y]+= num[x];
        }
       // System.out.println(x+" "+y+" "+num[y]);
    }

    static int find(int a) {
        if (arr[a] == a)
            return a;

        return arr[a] = find(arr[a]);
    }
}



