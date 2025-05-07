


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int c;
    static int ans;
    static int [][] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //두행 -> m개열 물건. 열 겹치면x
        //각 최대무게 x . m개열 중 x넘지않는 것만 고르기
        //가치 : w*w 최대

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x1 = 0; x1 < n; x1++) {
            for (int x2 = 0; x2 < n; x2++) {

                if (x1 == x2) {
                    ans = getSameLineVal(x1);
                }else {
                    ans =getDiffLineVal(x1,x2);
                }
                max = Math.max(max, ans);
            }
        }
        System.out.println(max);
    }


    static int getSameLineVal(int line) {

        int sum1 = 0;
        int sum2 = 0;
        int ansVal = Integer.MIN_VALUE;
        //열 고르기
        for (int i = 0; i <= n-2*m; i++) {
            maxVal = Integer.MIN_VALUE;
            getWeight(line,i, 0,0,0);
            sum1 = maxVal;

            for (int j = i+m; j <= n-m; j++) {
                maxVal = Integer.MIN_VALUE;
                getWeight(line,j, 0,0,0);
                sum2 = maxVal;

                ansVal = Math.max(ansVal, sum1 + sum2);
            }
        }

        return ansVal;
    }

    static int getDiffLineVal(int x1, int x2) {

        int sum1 = 0;
        int sum2 = 0;
        int ansVal = Integer.MIN_VALUE;
        //열 고르기
        for (int i = 0; i <= n-m; i++) {
            maxVal = Integer.MIN_VALUE;
            getWeight(x1,i, 0,0,0);
            sum1 = maxVal;

            for (int j = 0; j <= n-m; j++) {
                maxVal = Integer.MIN_VALUE;
                getWeight(x2,j, 0,0,0);
                sum2 = maxVal;

                ansVal = Math.max(ansVal, sum1+sum2);
            }
        }
        return ansVal;
    }

    //1. 전체 ox -> weight검사. if내부에서 또 계산해야함 for o1/ for x
    //2. 인수로  -> for o1/ for x  즉, list쓰냐 안쓰냐차이?
    //m개중 열 뽑기
    static void getWeight(int x, int y, int index, int weight, int val) {
        if (index == m) {
            if (weight <= c) {
               maxVal = Math.max(maxVal, val);
            }
            return;
        }

        getWeight(x,y,index+1, weight + arr[x][y+index], val + arr[x][y+index]*arr[x][y+index]);
        getWeight(x,y,index+1, weight, val);

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



