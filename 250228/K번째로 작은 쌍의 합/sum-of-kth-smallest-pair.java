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
    static int k;
    static double max = Double.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //각 수열에서 원소하나씩뽑아서 쌍들 구하고, 합 오름차순, k번째의 합

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int [] nArr = new int[n];
        int [] mArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);
        Arrays.sort(mArr);

        //12367
        //1578
        //조합

        //합은 long
        long index = 1;
        long ans = 0;
        loop:
        for (int i = 0; i < m; i++) {
            int a = mArr[i];
            for (int j = 0; j < n; j++) {
              int b = nArr[j];
              pq.add((long)a+b);
            }
            ans = pq.poll();
            if (index == k){
                break loop;
            }
            index++;

        }

        System.out.println(ans);

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



