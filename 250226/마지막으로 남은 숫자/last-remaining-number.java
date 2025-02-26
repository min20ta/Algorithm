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

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //큰 2개 뽑아 제거, 두수 차이 넣기
        //2개 동일시 넣기x
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            pq.add(-x);
        }

        while (pq.size() >= 2) {
            int max1 = -pq.poll();
            int max2 = -pq.poll();

            if (max1==max2)
                continue;
            pq.add(-(max1-max2));
        }

        System.out.println(-pq.poll());





    }
}


