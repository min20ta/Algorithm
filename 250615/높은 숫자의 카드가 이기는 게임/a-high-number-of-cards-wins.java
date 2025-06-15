


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
    static int n ;
    static int m;
    static int k ;
    static int[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 1; i <= 2*n ; i++) {
            treeSet.add(i);
        }

        for (int i = 0; i < n; i++) {
            int bCard = Integer.parseInt(br.readLine());
            treeSet.remove(bCard);
            arr[i] = bCard;
        }

        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int bCard = arr[i];
            if (treeSet.higher(bCard) != null){
                ans++;
                treeSet.remove(treeSet.higher(bCard));
            }
        }

        System.out.println(ans);






    }



}




