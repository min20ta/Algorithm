


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
    static int c;
    static int ans = 0;
    static int [] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        //+1, -1, /2, /3
        q.add(new pair(n, 0));
        bfs();
        System.out.println(ans);

    }

    static void bfs() {

        while (!q.isEmpty()) {
            pair p = q.poll();
            int n = p.num;
            int nx = 0;

            for (int i = 0; i < 4; i++) {
                if (i == 0)
                    nx =  n + 1;
                else if (i == 1)
                    nx = n - 1;
                else if (i == 2 && n %2 == 0)
                    nx = n / 2;
                else if (i == 3 && n % 3 == 0)
                    nx = n / 3;

                if (nx == 1){
                    ans = p.count+1;
                    return;
                }else if (nx > 0) {
                    q.add(new pair(nx, p.count+1));
                }
            }
        }
    }
    static class pair {
        int num;
        int count;

        pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }


}




