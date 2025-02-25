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
    static int lastTime = 0 ;
    static int ansSum;
    static int ansW;
    static int x = 0;
    static int y = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int num = -pq.poll();
            num--;
            pq.add(-num);
        }

        System.out.println(-pq.poll());

    }
}


