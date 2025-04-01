
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;
    static int r;
    static int c;
    static int u = 1;
    static int s = 3;
    static int f = 2;
    static int x ;
    static int y;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); r--;
        c = Integer.parseInt(st.nextToken()); c--;

        x = r; y = c;
        arr = new int[n][n];
        arr[r][c] = 6;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            char dir = st.nextToken().charAt(0);

            if (dir == 'L'){
                roll(0);
            }else if (dir == 'R') {
                roll(1);
            }else if (dir == 'D') {
                roll(2);
            }else {
                roll(3);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    //System.out.println(i+" "+j+ " "+arr[i][j]);
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
    static void roll(int d){
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
            return;
        }

        x = nx; y = ny;
        int pu = u;
        int ps = s;
        int pf = f;

        if (d == 0){
            arr[nx][ny] = 7-s;
            u = ps;
            s = 7-pu;
            f = f;
        }else if (d == 1){
            arr[nx][ny] = s;
            s = pu;
            u = 7-ps;
            f = f;
        }else if (d == 2) {
            arr[nx][ny] = f;
            s = s;
            u = 7 - pf;
            f = pu;
        }else {
            arr[nx][ny] = 7 - f;
            f = 7 - pu;
            u = pf;
            s = s;

        }

    }
}


