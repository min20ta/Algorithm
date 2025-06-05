


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k ;
    static int[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int ans = 0;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set = new TreeSet<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }


        getMin();
        System.out.println(ans);


    }
    static void getMin(){

        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();

            ans += a+ b;
            pq.add(a+b);
        }

    }
}








