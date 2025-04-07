
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int k;
    static int t;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static ArrayList<pair> [][] arr;
    static Queue<pair> q = new LinkedList<>();
    static Queue<pair> nextQ = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        //m개구슬
        //방향시간x
        //동일위치 k개 초과시 우선순위 높은 k개(속도, 번호) 남고
        // 나머지 폭발
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;
            char d = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());

            int dir = 0;
            if (d == 'L') dir = 0;
            else if (d == 'D') dir = 1;
            else if (d == 'U') dir = 2;
            else dir = 3;

            arr[r][c].add(new pair(r,c,dir,v, i+1));
            nextQ.add(new pair(r,c,dir,v, i+1));
        }

        while (t-- > 0) {
            move();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j].size();
            }
        }
        System.out.println(sum);

    }
    static void move() {

        q = new LinkedList<>(nextQ);
        nextQ = new LinkedList<>();

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int d = p.d;
            int v = p.v;
            int num = p.num;

            int curV = v;
            int timeV = v;
            int curX = x;
            int curY = y;

            int nx = -1;
            int ny = -1;
            //방향대로 속도칸 만큼 이동
            while (timeV-- > 0) {
                nx = x + dx[d];
                ny = y + dy[d];

                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    d = 3 - d;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx; y = ny;
            }

            //저장 후 원자리 삭제
            pair next = new pair(nx,ny,d,curV,num);
            arr[curX][curY].removeIf(q-> q.num == p.num);
            arr[nx][ny].add(next);

        }

        //폭탄후 다음큐저장
        bomb();
    }

    static void bomb() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              
                if (arr[i][j].size() > k) {
                    Collections.sort(arr[i][j]);
                    while (arr[i][j].size() != k) {
                        arr[i][j].remove(0);
                    }
                }
                if (arr[i][j].size() <= k){
                    //다음공
                    nextQ.addAll(arr[i][j]);
                }
            }
        }




    }
    static class pair implements Comparable<pair>{
        int x;
        int y;
        int d;
        int v;
        int num;

        pair(int x, int y, int d, int v, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.v = v;
            this.num = num;
        }

        @Override
        public int compareTo(pair p1) {
            if (this.v == p1.v)
                return this.num - p1.num;

            return this.v - p1.v;
        }

    }

}




