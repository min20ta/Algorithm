import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] ballMap;
    static pair[] ball;
    static int idx = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int t;
    static int stop = 0;
    static int prev;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair> tailList = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        ballMap = new int[n][n];
        ball = new pair[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;
            ball[i] = new pair(r,c);
            q.add(ball[i]);
            ballMap[r][c] = 1;
        }


//이렇게 동시에 변화가 일어나야 하는 경우에는
// 새로운 배열을 만들어 주는 것이 항상 좋습니다.

        // 동시에 바뀔때는 사라지지 않음

        while (t-- > 0){
            playBall();
        }

        System.out.println(count());

    }

    static void playBall() {

        while (!q.isEmpty()) {

            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int max = Integer.MIN_VALUE;
            pair maxSeat =  new pair(x,y);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx>=0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] > max) {
                        max = map[nx][ny];
                        maxSeat = new pair(nx,ny);
                    }
                }
            }
            // 다른 큐 및 전체 구슬개수 확인필요
            ballMap[maxSeat.x][maxSeat.y]++;
            ballMap[x][y]--;
        }
        
        bomb();



    }
    
    static void bomb() {

        //충돌은 폭발
        //1인것 큐에 다시 넣어주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballMap[i][j] >= 2)
                    ballMap[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballMap[i][j] == 1)
                    q.add(new pair(i,j));

                //System.out.print(ballMap[i][j]+" ");
            }
            //System.out.println();
        }

       // System.out.println();


    }

    static int count() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballMap[i][j] == 1)
                    count++;
            }
        }

        return count;
    }


    static class pair {
        int x;
        int y;


        pair(int x, int y) {
            this.x =x;
            this.y = y;



        }
        }
}

