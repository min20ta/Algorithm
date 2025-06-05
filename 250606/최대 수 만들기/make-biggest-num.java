


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
    static String[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static String ans = "";
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

        arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] =br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = n-1; i >=0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());



    }
   
    
}



