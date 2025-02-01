
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int k ;
    static int r1 ;
    static int c1 ;
    static int r2 ;
    static int c2 ;


    static ArrayList<pair> arrayList = new ArrayList<>();

    static boolean [][] visit;
    static boolean [][] kVisit;
    static int [][] arr;
    static int [][] lenArr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={-1,0,1,0};
    static Queue<pair> q = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    static int subMax = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());



        arr = new int[n][n];
        lenArr = new int[n][n];
        visit = new boolean[n][n];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] =num;
                if (num== 2){
                    q.add(new pair(i,j));
                    visit[i][j] = true;
                }
            }
        }

        //0=아무것도x, 1=귤, 2=상한귤
        // 상한귤로 부터 각귤이 상하게 되는 시간
        //출력 : 처음비어있던칸 = -1, 끝까지 상하지 않은 귤 = -2

        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0)
                    System.out.print(-1+" ");
                else if (!visit[i][j])
                    System.out.print(-2+" ");
                else
                    System.out.print(lenArr[i][j]+" ");
            }
            System.out.println();
        }


    }



    static void bfs() {

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny]&& arr[nx][ny] ==1) {
                        visit[nx][ny] = true;
                        lenArr[nx][ny] = lenArr[x][y] + 1;
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










