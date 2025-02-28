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
    static long max = Long.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //각 수열에서 원소하나씩뽑아서 쌍들 구하고, 합 오름차순, k번째의 합

        PriorityQueue<pair> pq = new PriorityQueue<>();

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

        for (int i = 0; i < n; i++) {
            pq.add(new pair((long)nArr[i]+mArr[0], i, 0));
        }
        //최소값찾고 버린후, 다음 최소값 후보 추가 반복
        for (int i = 0; i < k-1; i++) {
            pair p = pq.poll();
            int index1 = p.index1;
            int index2 = p.index2;

            index2++;
            if (index2 < m)
                pq.add(new pair((long)nArr[index1] + mArr[index2], index1, index2));
        }

        System.out.println(pq.peek().sum);



        }



    static class pair implements Comparable<pair> {
        long sum;
        int index1;
        int index2;

        pair(long sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public int compareTo(pair p){
            if (this.sum == p.sum)
                return this.index1 - p.index1;
            if (this.index1 == p.index1)
                return this.index2 - p.index2;
            return (int) (this.sum - p.sum);
        }
    }

    }



