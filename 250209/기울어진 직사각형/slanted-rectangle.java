
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = 0;






    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 1; k <= n-1 ; k++) {
                    int sum = 0;
                    for (int l = 1; l <= n-1 ; l++) {
                        sum = getSize(i,j, k, l);
                        //System.out.println(sum+" "+i+" "+j+" "+k+" "+l);
                        max = Math.max(max, sum);
                    }

                }
            }
        }

        System.out.println(max);

    }

    static int getSize(int x, int y, int h, int w) {
        int sum = arr[x][y];
        int rx = x;
        int ry = y;
        int nx = 0 ;
        int ny = 0 ;

        for (int i = 0; i < h; i++) {
            nx = x + dx[0];
            ny = y + dy[0];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sum += arr[nx][ny];
                x = nx; y = ny;
            }else
                return 0;
        }


        for (int i = 0; i < w; i++) {
            nx = x + dx[1];
            ny = y + dy[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sum += arr[nx][ny];
                x = nx; y = ny;
            }else
                return 0;
        }

        for (int i = 0; i < h; i++) {
            nx = x + dx[2];
            ny = y + dy[2];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sum += arr[nx][ny];
                x = nx; y = ny;
            }else
                return 0;
        }

        for (int i = 0; i < w; i++) {
            nx = x + dx[3];
            ny = y + dy[3];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                sum += arr[nx][ny];
                x = nx; y = ny;
            }else
                return 0;
        }

        return sum - arr[rx][ry];
    }





    }



