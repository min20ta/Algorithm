
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
        kVisit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] =num;
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        r1--; c1--; r2--; c2--;

        findK(0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);


    }

    static void findK(int count) {
        if (count == k) {
            bfs();

            if (visit[r2][c2]) {
                int sub = lenArr[r2][c2];
                min = Math.min(min,sub);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!kVisit[i][j] && arr[i][j] == 1){
                    kVisit[i][j] = true;
                    arrayList.add(new pair(i,j));
                    findK(count+1);
                    arrayList.remove(arrayList.size()-1);
                    kVisit[i][j] = false;
                }
            }
        }
    }



    static void bfs() {

        for (int i = 0; i < k; i++) {
            pair p = arrayList.get(i);
            arr[p.x][p.y] = 0;
        }
        lenArr = new int[n][n];
        visit = new boolean[n][n];

        q.add(new pair(r1, c1));
        visit[r1][c1] = true;

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visit[nx][ny] && arr[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        lenArr[nx][ny] = lenArr[x][y] + 1;
                        if (nx == r2 && ny == c2)
                            break;
                        q.add(new pair(nx, ny));
                    }
                }
            }
        }

        //복원
        for (int i = 0; i < k; i++) {
            pair p = arrayList.get(i);
            arr[p.x][p.y] = 1;
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










