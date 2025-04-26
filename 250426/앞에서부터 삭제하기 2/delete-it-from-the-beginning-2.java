
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static int [] arr;
    static int [] y;
    static int [] L;
    static int [] R;


    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        //k(1~n-2)개 삭제, 남아있는 정수중 가장 작은거 제외한 평균-> 최대
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        //10^6
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[n-1]);
        int sum = arr[n-1];
        int count = 1;

        for (int i = n-2; i >= 0; i--) { //삭제 k구하기
            pq.add(arr[i]);
            sum += arr[i];
            max = Math.max(max, (double)(sum-pq.peek())/(count++));
        }

        System.out.println(String.format("%.2f", max));






    }



}



