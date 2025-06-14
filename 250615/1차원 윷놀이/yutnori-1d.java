


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
    static int[] board;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] v;


    static int max = Integer.MIN_VALUE;
    static int minCar = Integer.MAX_VALUE;
    static int diffMin = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //1~m.
        //k개 말. m도달시 1점
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getMax(0);
        System.out.println(max);


    }

    static void getMax(int index) {
        if (index == n) {
            max = Math.max(max, doGame());
            return;
        }

        for (int i = 1; i <= k ; i++) {
            list.add(i);
            getMax(index+1);
            list.remove(list.size()-1);
        }
    }

    static int doGame() {
        int index = 0;
        int score = 0;
        board = new int[k+1];

        for (int node: list){
            board[node] = board[node] + arr[index++];
        }

        for (int i = 1; i <= k; i++) {
            if (board[i] >= m-1)
                score++;
        }

        return score;
    }


}



