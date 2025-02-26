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

        ArrayList<Integer> list = new ArrayList<>();

        // k개 삭제후, 남아있는 것중가장작은 거 하나 제외한 평균.
        // 평균 최대

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }


        //완탐
        //10^5 * 5
        // copyPQ = new PriorityQueue<>(pq);
        //pq도 remove가능
        
        // 3 1 9 2 7 
        int sum = list.get(n-1);
        int min = list.get(n-1);
        for (int k = n-2; k >= 1 ; k--) {
            sum += list.get(k);
            
            min = Math.min(min, list.get(k));
            
            sum -= min;
            
            double avg = (double)sum/(n-k-1);
            max = Math.max(max, avg);
            sum += min;

        }

        System.out.printf("%.2f\n", max);

    }
}


