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
    static double max = Double.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> copyPQ = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        // k개 삭제후, 남아있는 것중가장작은 거 하나 제외한 평균.
        // 평균 최대

        st = new StringTokenizer(br.readLine());
        int sum = 0; int copySum =0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
            pq.add(x);
            sum += x;
        }


        //완탐
        //10^5 * 5
        for (int k = 1; k <= n-2 ; k++) {
            copySum = sum;
            copyPQ = new PriorityQueue<>(pq);

            for (int i = 0; i < k; i++) {
                copySum -= list.get(i);
                copyPQ.remove(i);
            }

            copySum -= copyPQ.poll();
            double avg = (double)copySum/(n-k-1);
            max = Math.max(max, avg);

        }

        System.out.printf("%.2f\n", max);

    }
}


