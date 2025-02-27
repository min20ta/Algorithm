import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int t;
    static double max = Double.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        //홀수번째마다 중앙값출력. 오름차순

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int [] arr = new int[m];

            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                pq.add(x);
                arr[j] = x;

                if (j % 2 == 0) {
                    for (int k = j/2+1; k <= j ; k++) {
                        pq.poll();
                    }
                    System.out.print(pq.poll()+" ");
                    for (int k = j/2; k <= j ; k++) {
                        pq.add(arr[k]);
                    }
                }
            }
            System.out.println();
        }



    }
}


