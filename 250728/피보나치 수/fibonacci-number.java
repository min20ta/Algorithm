


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

    static boolean cycle ;
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
        
    }

}




