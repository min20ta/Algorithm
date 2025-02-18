import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[] num;
    static pair[] display;
    static int[][] dir;
    static int[][] dir2;
    static int idx = 0;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int n;
    static int m;
    static int t;
    static int x = 0;
    static int y = 0;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<Integer>[][] list;
    static ArrayList<pair> list2 = new ArrayList<>();
    static ArrayList<int[][]> dirList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[m];
        list = new ArrayList[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            findMax(num[i]);
        }


        printAns();


    }

    static void findMax(int num) {

        pair curPosition = getPosition(num);

        int max = Integer.MIN_VALUE;
        int maxX = 0;
        int maxY = 0;
        int nx = 0;
        int ny = 0;

        for (int i = 0; i < 8; i++) {
            nx = curPosition.x + dx[i];
            ny = curPosition.y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                for (int j = 0; j < list[nx][ny].size(); j++) {
                    if (list[nx][ny].get(j) > max) {
                        max = list[nx][ny].get(j);
                        maxX = nx;
                        maxY = ny;
                    }
                }
            }
        }
        //System.out.println(max + " "+ maxX+" "+maxY);
        //최대값 자리로 이동
        //내 위 애들 찾아서
        if(max != Integer.MIN_VALUE)
            move(curPosition, maxX, maxY, num);

    }

    static pair getPosition(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < list[i][j].size(); k++) {
                    if (list[i][j].get(k) == num)
                        return new pair(i, j);
                }
            }
        }
        return new pair(0, 0);
    }

    static void move(pair cur, int nx, int ny, int num) {
        int x = cur.x;
        int y = cur.y;
        boolean canMove = false;

        for (int i = 0; i < list[x][y].size(); i++) {
            if (list[x][y].get(i) == num) {
                canMove = true;
            }

            if (canMove)
                list[nx][ny].add(list[x][y].get(i));
        }

        //원래자리 삭제
        while (list[x][y].get(list[x][y].size() - 1) != num) {
            list[x][y].remove(list[x][y].size() - 1);
        }
        list[x][y].remove(list[x][y].size() - 1);

    }


    static void printAns() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list[i][j].size() == 0)
                    System.out.println("None");
                else {
                    for (int k = list[i][j].size() - 1; k >= 0; k--) {
                        System.out.print(list[i][j].get(k) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }


    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


