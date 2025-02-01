
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int h ;
    static int m ;

    static ArrayList<pair> arrayList = new ArrayList<>();

    static boolean [][] visit;
    static int [][] arr;
    static int [][] lenArr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={-1,0,1,0};
    static Queue<pair> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n][n];
        lenArr = new int[n][n];
        visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] =num;
                if (num == 3){
                    q.add(new pair(i,j));
                    visit[i][j] = true;
                }

            }
        }

        //h명 겹치지 않게,
        //m: 비 파는 공간
        //각 사람마다 비 피하는 가까운 거리
        //0: 이동, 1:벽, 2:사람, 3:비피하는 공간


        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2 && visit[i][j]){
                    System.out.print(lenArr[i][j]+" ");
                }else if (arr[i][j] == 2 && !visit[i][j])
                    System.out.print(-1+" ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }

    }


    static void bfs() {


        while (!q.isEmpty())  {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny]) {
                        if (arr[nx][ny] != 1){
                            visit[nx][ny] = true;
                            if (lenArr[nx][ny] != 0)
                                lenArr[nx][ny] = Math.min(lenArr[nx][ny],lenArr[x][y] +1);
                            else
                                lenArr[nx][ny] = lenArr[x][y] +1;
                            q.add(new pair(nx, ny));
                        }if (arr[nx][ny] == 0){
                            q.add(new pair(nx, ny));
                        }
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










