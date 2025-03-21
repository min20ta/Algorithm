
import java.util.*;
import java.io.*;


public class Main {

    static int[] dp;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;

    static int max = Integer.MIN_VALUE;
    static int count = 0;




    static int ans = 0;
    static boolean[][] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();
    static int meltCounts = 0;
    static int t = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        //-1, +1, 2의배수 /2, 3의배수 /3
        //1을 만들기 위한 최소연산

        //풀이:
        //  4가지 bfs
        // 조합 -> 종료조건 : 매번 확인해야함
        // 숫자 배열에 dp min

        dp = new int[1000001];
        Arrays.fill(dp,Integer.MAX_VALUE);
        q.add(n);


        bfs();
        System.out.println(dp[1]);


    }
    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == 1)
                break;

            for (int i = 0; i < 4; i++) {
                int nx = 0 ;
                if (i == 0)
                    nx = x -1;
                else if (i == 1)
                    nx = x + 1;
                else if (i == 2) {
                    if (x%2 == 0)
                        nx = x/2;
                    else
                        continue;
                }else {
                    if (x % 3 == 0)
                        nx = x/3;
                    else
                        continue;
                }

                if (nx < 1)
                    continue;

                if (dp[x] == Integer.MAX_VALUE)
                    dp[x] = 0;

                dp[nx] = Math.min(dp[nx], dp[x]+1);
                //System.out.println(dp[nx]);
                q.add(nx);
            }

        }
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
