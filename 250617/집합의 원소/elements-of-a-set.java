


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
    static int[][] dirArr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[][] visit;
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

        arr = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());



            if (question == 0) {
                union(a,b);
            }else {
                if (find(a) == find(b))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }


    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        arr[x] = y;
    }

    static int find(int x) { //최고조상찾기
        if (arr[x] == x)
            return x;

        return arr[x] = find(arr[x]);
    }



}




