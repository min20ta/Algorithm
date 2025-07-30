


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
        int t = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        while (t-- > 0) {
            int num = list.remove(list.size()-1);
            list.add(0,num);
        }

        int count = 0;
        for (int i = 0; i < 2*n; i++) {
                System.out.print(list.get(i)+" ");
                count++;
                if(count == n)
                    System.out.println();
        }


    }

}




