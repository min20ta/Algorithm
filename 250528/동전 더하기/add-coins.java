


import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set = new TreeSet<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = n-1; i >= 0 ; i--) {
            int num = k /arr[i];
            k = k - arr[i]*num;
            count += num;
            
            if (k == 0)
                break;




        }

        System.out.println(count);


    }
}




