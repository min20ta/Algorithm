


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
    static String[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        //1~k n번
        //연속3번 x
        findCombination(0);


    }
    static void findCombination(int index) {
        if (index == n){
            for (int num : list)
                System.out.print(num+" ");
            System.out.println();
            return;
        }

        for (int i = 1; i <=k ; i++) {
            if (!(list.size() >= 2 && list.get(list.size()-2) == i && list.get(list.size()-1) == i)) {
                list.add(i);
                findCombination(index + 1);
                list.remove(list.size() - 1);
            }
        }
    }


}



