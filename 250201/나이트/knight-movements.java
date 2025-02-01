
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int r1 ;
    static int c1 ;
    static int r2;
    static int c2;

    static ArrayList<pair> arrayList = new ArrayList<>();

    static boolean [][] visit;
    static int [][] arr;
    static int [][] lenArr;
    static int [] dx ={-2,-1,1,2,2,1,-1,-2};
    static int [] dy ={1,2,2,1,-1,-2,-2,-1};
    static Queue<pair> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        arr = new int[n+1][n+1];
        lenArr = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];
        for (int [] i : lenArr)
            Arrays.fill(i,-1);
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();
        if (lenArr[r2][c2] == -1)
            System.out.println(-1);
        else
            System.out.println(lenArr[r2][c2]);
    }


    static void bfs() {
        q.add(new pair(r1,c1));
        visit[r1][c1] = true;
        lenArr[r1][c1] = 0;

        while (!q.isEmpty())  {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    if (!visit[nx][ny]) {
                        visit[nx][ny] = true;
                        lenArr[nx][ny] = lenArr[x][y] +1;
                        if (nx == r2 && ny == c2)
                            break;
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













