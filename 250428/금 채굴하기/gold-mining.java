
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
    static int [][] arr;
    static int [] L;
    static int [] R;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //금 1개 가격

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //m*금개수 - 비용 >= 0 일때 금개수 최대

        for (int k = 0; k <= n ; k++) {  //k
            for (int i = 0; i < n; i++) { //중심점 위치
                for (int j = 0; j < n; j++) {
                    int gold = getGold(k,i,j);
                    int money = k*k + (k+1)*(k+1);

                    if (gold*m - money >= 0) {
                        max = Math.max(max, gold);
                    }
                }
            }
        }

        System.out.println(max);

    }
    static int getGold(int k, int x, int y) {

        int gold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(x-i)+ Math.abs(y-j) <= k) {
                    if (arr[i][j] == 1) {
                        gold++;
                    }
                }
            }
        }

        return gold;

    }



}



