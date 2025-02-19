import java.util.*;
import java.io.*;


public class Main {
    static pair[][] map;
    static pair[] num;
    static pair[] display;
    static int[][] dir;
    static int[][] dir2;
    static int idx = 0;
    static int[] dx = {0,1,-1,0};
    static int[] dy = {-1,0,0,1};
    static int n;
    static int m;
    static int t;
    static int ansSum;
    static int ansW;
    static int x = 0;
    static int y = 0;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<pair>[][] list;
    static ArrayList<pair> [][] nextList ;
    static ArrayList<int[][]> dirList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new ArrayList[n][n];
        nextList = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = new ArrayList<>();
                nextList[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); r--;
            int c = Integer.parseInt(st.nextToken()); c--;
            char d = st.nextToken().charAt(0);
            int w = Integer.parseInt(st.nextToken());

            int dir = 0;
            if (d == 'L') dir = 0;
            else if (d == 'D') dir = 1;
            else if (d == 'U') dir = 2;
            else if (d == 'R') dir = 3;

            list[r][c].add(new pair(dir,w,i));
        }

        while (t-->0) {
            move();
            bomb();
        }

        count();
        System.out.println(ansSum+" "+ansW);



    }


    static void move() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextList[i][j] = new ArrayList<pair>();
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                    for (int l = 0; l < list[x][y].size(); l++) {
                        int d = list[x][y].get(l).d;
                        int w = list[x][y].get(l).w;
                        int num = list[x][y].get(l).num;

                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                            d = 3-d;
                            nextList[x][y].add(new pair(d,w,num));
                        }else
                            nextList[nx][ny].add(new pair(d,w,num));
                    }
                }
            }
        }


    static void bomb() {
        int max = Integer.MIN_VALUE;
        int maxD = -1;
        int sum = 0;


        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                max = Integer.MIN_VALUE;
                sum = 0;
                for (int l = 0; l < nextList[x][y].size(); l++) {
                    sum += nextList[x][y].get(l).w;
                    if (nextList[x][y].get(l).num > max) {
                        max = nextList[x][y].get(l).num;
                        maxD = nextList[x][y].get(l).d;
                    }
                }
                if (nextList[x][y].size() >0){
                    nextList[x][y].clear();
                    nextList[x][y].add(new pair(maxD,sum,max)); }
               // System.out.println(x+" "+y+" "+maxD+" "+ sum+" "+max);
            }
        }

        //nextList -> list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = (ArrayList<pair>) nextList[i][j].clone();
            }
        }
    }

    static void count() {
        ansSum = 0;
        ansW = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ansSum+=list[i][j].size();
               // System.out.println(i+" "+j+" "+list[i][j].size());
                for (int l = 0; l < list[i][j].size(); l++) {
                    ansW = Math.max(ansW, list[i][j].get(l).w);
                }
            }
        }

    }





    static class pair  {
        int d;
        int w;
        int num;

        pair(int d, int w, int num) {
            this.d = d;
            this.w = w;
            this.num = num;
        }

    }
}


