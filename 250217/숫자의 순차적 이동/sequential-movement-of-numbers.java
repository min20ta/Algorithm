import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int idx = 0;
    static int[] dx = {-1,-1, -1, 0, 0,1,1,1};
    static int[] dy = {-1,0, 1, -1, 1,-1,0,1};
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

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



//이렇게 동시에 변화가 일어나야 하는 경우에는
// 새로운 배열을 만들어 주는 것이 항상 좋습니다.

        // 동시에 바뀔때는 사라지지 않음

        while (m-- > 0){
            next = 1;
            while (next <= n*n) {
                loop:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == next) {
                            play(i, j);
                            next++;
                            break loop;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void play(int x, int y) {

        max = Integer.MIN_VALUE;
        pair maxSeat = new pair(x,y);

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] > max){
                    max = map[nx][ny];
                    maxSeat = new pair(nx,ny);
                }
            }
        }

        change(x,y,maxSeat.x, maxSeat.y);


    }
    

    static void change(int x, int y, int nx, int ny) {
        int temp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = temp;
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

