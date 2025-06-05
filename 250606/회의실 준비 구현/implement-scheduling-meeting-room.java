


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
    static pair[] arr;
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

        arr = new pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new pair(s,e);
        }

        Arrays.sort(arr);
        pair p1 = arr[0];
        ans++;

        for (int i = 1; i < n; i++) {
            pair p2 = arr[i];

            if(p1.e <= p2.s){
                ans++;
                p1 = p2;
            }

        }

        System.out.println(ans);

    }
    static class pair implements Comparable<pair>{
        int s;
        int e;

        pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(pair p) {
            if (this.e == p.e)
                return this.s - p.s;
            return this.e - p.e;
        }
    }
}




