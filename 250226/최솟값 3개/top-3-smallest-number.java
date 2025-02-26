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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 가장 작은 숫자 3개 곱

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long x = Integer.parseInt(st.nextToken());
            pq.add(x);

            if (pq.size() >= 3){
                long a = pq.poll();
                long b = pq.poll();
                long c = pq.poll();
                System.out.println(a*b*c);
                pq.add(a); pq.add(b); pq.add(c);
            }else
                System.out.println(-1);


        }





    }
}


