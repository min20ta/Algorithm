


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
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set = new TreeSet<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = arr[0];
        max = num;
        
        for (int i = 1; i < n; i++) {

            if (num < num+arr[i] && num > 0)
                num += arr[i];
            else if (num < arr[i])
                num = arr[i];
            else {
                num = 0;
            }
            max = Math.max(max,num);
        }

        System.out.println(max);



    }
}




