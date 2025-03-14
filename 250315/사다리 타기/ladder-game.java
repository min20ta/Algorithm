
import java.util.*;
import java.io.*;


public class Main {

    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[] ansArr ;
    static pair[] arr;
    static int[][] copyArr;
    static int ans = 0;
    static boolean [][] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;



    static ArrayList<pair> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new pair(a,b);
        }

        Arrays.sort(arr);

        ansArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ansArr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int left = arr[i].x;
            int right = left+1;

            int temp = ansArr[left];
            ansArr[left] = ansArr[right];
            ansArr[right] = temp;
        }

        findMin(0);
        System.out.println(min);
    }

    static void findMin(int idx) {

        if (idx == m) {
            if (checkLadder())
                min = Math.min(min, list.size());
            return;
        }


        list.add(arr[idx]);
        findMin(idx+1);
        list.remove(list.size()-1);
        findMin(idx+1);

    }

    static boolean checkLadder() {
        int [] checkArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            checkArr[i] = i;
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int left = list.get(i).x;
            int right = left+1;

            int temp = checkArr[left];
            checkArr[left] = checkArr[right];
            checkArr[right] = temp;
        }


        for (int i = 1; i <= n; i++) {
            if (ansArr[i] != checkArr[i])
                return false;
        }
        return true;
    }





    static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p1) {
            if (this.y == p1.y)
                return this.x - p1.x;
            return this.y - p1.y;
        }
    }
  

}