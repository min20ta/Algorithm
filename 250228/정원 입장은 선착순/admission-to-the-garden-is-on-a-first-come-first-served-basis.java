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
        n = Integer.parseInt(st.nextToken());

        //1~n 번호작은사람부터. 모든사람 정원. 가장 오래 기다려야 하는 사람 시간

        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.a - o2.a;
            }
        });
        PriorityQueue<pair> pq2 = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.index - o2.index;
            }
        });

        int time = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int index = i;
            pq.add(new pair(a,t,index));
        }
        pair p = pq.poll();
        time = p.a + p.t;
        int wait = Integer.MIN_VALUE;

        while (true){
            if (!pq2.isEmpty()) {
                pair nextP = pq2.poll();
             
                if (time < nextP.a)
                    time = nextP.a + nextP.t;
                else {
                    wait = Math.max(wait, time - nextP.a);
                    time += nextP.t;
                }
             //   System.out.println(time+" "+ nextP.a+" "+nextP.t);


            }

            if (pq.isEmpty() && pq2.isEmpty())
                break;


            if (!pq.isEmpty() && !pq2.isEmpty() &&
                    pq2.peek().a <=time && time < pq.peek().a){
                pq2.add(pq.poll());
            } else {
                while (!pq.isEmpty() && time >= pq.peek().a) {
                    pq2.add(pq.poll());
                }
            }
        }
        System.out.println(wait);


    }

    static class pair {
        int a;
        int t;
        int index;

        pair(int a, int t, int index){
            this.a = a;
            this.t = t;
            this.index = index;
        }

    }


    }




