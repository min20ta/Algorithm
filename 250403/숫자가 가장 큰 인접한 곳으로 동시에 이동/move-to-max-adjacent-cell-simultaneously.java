
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[][] diceArr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0,-1, 1};
    static int n;
    static int m;
    static int t;
    static int c;
    static int u = 1;
    static int s = 3;
    static int f = 2;
    static int mx ;
    static int my;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        //큰값 여러개일때 : 상하좌우 우선순위
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;
            nextQ.add(new pair(r,c));

        }
        while (t-- > 0) {
            diceArr = new int[n][n];
            roll();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(diceArr[i][j]+" ");
//                }
//                System.out.println();
//            }
  //          System.out.println();
            bomb();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(diceArr[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (diceArr[i][j] == 1){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    //가장 큰게 2개 이상일때, 상하좌우 우선순위
    static void roll() {
        q = new LinkedList<>(nextQ);
        nextQ = new LinkedList<>();

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int nx; int ny;
            mx = 0; my = 0;
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny< n) {
                    list.add(arr[nx][ny]);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            if (list.get(0) == list.get(1))
                doOrder(x,y);
            else
                doMax(x,y);

            diceArr[mx][my]++;
            nextQ.add(new pair(mx,my));
        }

    }

    static void bomb() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (diceArr[i][j] >= 2) {
                    diceArr[i][j] = 0;
                }
            }
        }
    }

    static void doOrder(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny< n) {
                mx = nx; my = ny;
                return;
            }
        }
    }

    static void doMax(int x, int y) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny< n) {
                if (max < arr[nx][ny]) {
                    max = arr[nx][ny];
                    mx = nx;
                    my = ny;
                }

            }
        }
    }
    static class pair {
        int x;
        int y;
        int num;
        int index;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
}


