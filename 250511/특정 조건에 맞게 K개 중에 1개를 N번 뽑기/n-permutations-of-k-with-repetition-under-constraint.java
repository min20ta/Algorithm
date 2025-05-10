


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
    static int [][] arr;
    static int [] distance;
    static boolean[] visit;
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int alphaSize;
    static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        getNums(0);
    }

    static void getNums(int index) {
        if (index == n) {
            for (int num : list)
                System.out.print(num+" ");
            System.out.println();
            return;
        }

        for (int i = 1; i <=k ; i++) {
            if (!(list.size()>=2 && list.get(list.size()-1) == i
                    && list.get(list.size()-2) == i)) {
                list.add(i);
                getNums(index + 1);
                list.remove(list.size() - 1);
            }
        }
    }



}




