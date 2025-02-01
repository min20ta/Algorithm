
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;

    static ArrayList<pair> arrayList = new ArrayList<>();

    static boolean [][] visit;
    static int [][] arr;
    static int [][] lenArr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};
    static Queue<pair> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        lenArr = new int[n][m];
        visit = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

            }
        }

        bfs();
        if (lenArr[n-1][m-1] == 0)
            System.out.println(-1);
        else
            System.out.println(lenArr[n-1][m-1]);
    }


    static void bfs() {
        q.add(new pair(0,0));
        visit[0][0] = true;
        lenArr[0][0] = 0;

        while (!q.isEmpty())  {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visit[nx][ny] && arr[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        lenArr[nx][ny] = lenArr[x][y] +1;
                        q.add(new pair(nx, ny));
                    }
                }
            }
        }
    }
    static class pair{
        int x;
        int y;


        pair(int x, int y){
            this.x = x;
            this.y = y;

        }
        }

        }










