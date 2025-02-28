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
        PriorityQueue<Long> pq2 = new PriorityQueue<>();

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
        //중간에 정리가 필요할듯

        long index = 0;
        long ans = 0;
        boolean stop = false;

        loop:
        for (int i = 0; i < m; i++) {
            int a = mArr[i];
            for (int j = 0; j < n; j++) {
              int b = nArr[j];
              pq.add((long)a+b);
             // pq2.add((long)a+b);
            }

            while (i!= m-1 && !pq.isEmpty() && pq.peek() < mArr[i+1]+nArr[0]) {
                    index++;
                    ans = pq.poll();
               System.out.println(ans+" "+index);
                    if (index == k) {
                        stop = true;
                        break loop;
                    }
            }

            }

        if (stop)
            System.out.println(ans);
        else {

            while (!pq.isEmpty()) {
                index++;
                ans = pq.poll();
                System.out.println(ans + " " + index);
                if (index == k) {
                    break;
                }
            }

            System.out.println(ans);
        }

    }




    }



