
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;

    static int max = Integer.MIN_VALUE;
    static int count = 0;




    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static Queue<pair> q = new LinkedList<>();



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //마름모 모양 한번
        //중심점 기준 k번이내 상하좌우
        //비용 : 격자개수
        //금 = 1
        //답: 가장많은 금의 수. 채굴 <= m*금개수

        //풀이: 중심점구하기, k구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //중심점들
                //k 최대값은 넉넉잡아 n
                for (int k = 0; k < n ; k++) {
                    max = Math.max(max, calc(i,j,k));
                }
            }
        }
        System.out.println(max);
    }

    static int calc(int x, int y, int k) {
        int gold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i-x)+Math.abs(j-y) <= k) { //마름모에 속함
                    if (arr[i][j] == 1)
                        gold++;
                }
            }
        }

        int fee = k*k + (k+1)*(k+1);
        if (fee <= gold*m)
            return gold;
        else
            return 0;




    }


  static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
  }
}