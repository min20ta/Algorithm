import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int [][] arr;
    static int [][] dp;

    static int [] a;
    static int [] b;
    static Map<Integer,Integer> map = new HashMap<>();
    static TreeSet<Integer> nums = new TreeSet<>();


    static final int MAX_NUM = 100000;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // n개의 점 . 구간내점개수

        int [] arr = new int[MAX_NUM];
        pair [] queries = new pair[MAX_NUM];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queries[i] = new pair(start,end);
        }


        //좌표값 treeset에 넣기
        for (int i = 0; i < n; i++) {
            nums.add(arr[i]);
        }

        //좌표압축
        int count = 1;
        for (Integer num : nums) {
            map.put(num, count++);
        }

        for (int i = 0; i < q; i++) {
            int a = queries[i].x;
            int b = queries[i].y;

            int newA = map.get(a);
            int newB = map.get(b);

            System.out.println(newB-newA+1);
        }



        }


    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    }










