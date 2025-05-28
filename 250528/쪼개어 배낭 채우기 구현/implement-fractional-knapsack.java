


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
    static int[] w;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set = new TreeSet<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new pair[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            double wv = (double)v / w;

            arr[i] = new pair(w,v,wv);
        }

        Arrays.sort(arr);
        double ans = 0;
        int limit = m;

        for (int i = n-1; i >= 0 ; i--) {
            if (limit > arr[i].w){
                ans += arr[i]. v;
                limit -= arr[i].w;
            }else {
                ans += arr[i].wv *limit;
                break;
            }

            //System.out.println(ans);

        }

        System.out.printf("%.3f",ans);




    }
    static class pair implements Comparable<pair>{
        int w;
        int v;
        double wv;

        pair(int w, int v, double wv) {
            this.w = w;
            this.v = v;
            this.wv = wv;
        }

        @Override
        public int compareTo(pair p) {
            return Double.compare(this.wv, p.wv);
        }
    }
}




