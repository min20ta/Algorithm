import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] snake;
    static pair [] apple;
    static char [] dir;
    static int [] dirNum;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1,};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static int k;
    static int t = 0;
    static int stop = 0;
    static pair head;
    static pair tail;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair> tailList = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        snake = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); x--;
            int y = Integer.parseInt(st.nextToken()); y--;
            map[x][y] = 1;
        }

        dir = new char[k];
        dirNum = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            dir[i] = c;
            dirNum[i] = num;
        }

        tailList.add(new pair(0,0));
        head = new pair(0,0);

        for (int i = 0; i < k; i++) {
            char c = dir[i];
            int num = dirNum[i];
            stop = 0;
            snake(c, num);
            if (stop == 1)
                break;
        }
        System.out.println(t);


        }
  static void snake(char d, int p) {
      int dir = 0;
      if (d == 'L') dir = 0;
      else if (d == 'D') dir = 1;
      else if (d == 'R') dir = 2;
      else if (d == 'U') dir = 3;

      int x = head.x; int y = head.y;

      while (p-- > 0) {
          int nx = x + dx[dir];
          int ny = y + dy[dir];
          t++;

          //System.out.println(nx + " "+ ny);

          if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) { //격자 벗어날때
              stop = 1;
              return;
          }

          tail = tailList.get(0);
          if (bumpSnake(nx, ny, tail.x, tail.y)) { //충돌
              stop = 1;
              return;
          }

          snake[nx][ny] = 2; //머리
          snake[x][y] = 1; //몸
          tailList.add(new pair(nx, ny));
          head = new pair(nx, ny);

          if (map[nx][ny] == 0) { //사과x
              snake[tail.x][tail.y] = 0; //꼬리삭제
              tailList.remove(0);
          } else {//사과o
              map[nx][ny] = 0;
          }

          x = nx; y = ny;
      }

  }

  static boolean bumpSnake(int newHeadX, int newHeadY, int tailX, int tailY) {
        if (snake[newHeadX][newHeadY] == 1 && !(newHeadX == tailX && newHeadY == tailY))
            return true;
        return false;
  }

    static class pair {
        int x;
        int y;
        int t;

        pair(int x, int y) {
            this.x =x;
            this.y = y;


        }
        }
}

