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
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                    pq.add(-num);
            }else if (str.equals("size")){
                System.out.println(pq.size());
            }else if (str.equals("pop")) {
                System.out.println(-pq.poll());
            } else if (str.equals("empty")) {
                if (pq.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (str.equals("top")) {
                System.out.println(-pq.peek());
            }
        }

    }
}


