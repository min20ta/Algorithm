


import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    static int q ;
    static pair[] arr;
    static int [][] prefixSum;
    static int [] distance;
    static boolean[] visit;
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static TreeSet<Integer> set = new TreeSet<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new pair[n];
        prefixSum = new int[5002][5002];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new pair(x,y);
            set.add(x);
            set.add(y);
        }

        int count = 1;
        for (Integer num : set) {
            map.put(num, count++);
        }

        //좌표압축
        for (int i = 0; i < n ; i++) {
            int x = arr[i].x;
            int y = arr[i].y;

            int nx = map.get(x);
            int ny = map.get(y);

            prefixSum[nx][ny]++;
        }

        for (int i = 1; i <= count ; i++) {
            for (int j = 1; j <= count ; j++) {
                prefixSum[i][j] += prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int nx1 = getUpper(x1);
            int ny1 = getUpper(y1);
            int nx2 = getLower(x2);
            int ny2 = getLower(y2);

            System.out.println(getSum(nx1,ny1,nx2,ny2));

        }


    }
    static int getUpper(int x) {
        if (set.ceiling(x)== null)
            return set.size()+1;

        return map.get(set.ceiling(x));
    }

    static int getLower(int x) {
        if (set.floor(x) == null)
            return 0;
        return map.get(set.floor(x));
    }

    static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
    }

static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p) {
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;
        }
}

}




