
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int k ;
    static int u ;
    static int d ;
    static ArrayList<pair> arrayList = new ArrayList<>();
    static ArrayList<pair> meltList = new ArrayList<>();
    static ArrayList<pair> testMeltList = new ArrayList<>();
    static boolean [][] visit;
    static boolean [][] bfsVisit;
    static int [][] arr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};
    static Queue<pair> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

            }
        }

        findK(0);
        System.out.println(max);
    }

    //k개 도시 골라서 갈수있는 곳(상하좌우, 높이차u~d) 최대

    static void findK(int depth) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                q.add(arrayList.get(i));
            }
            subMax = k;
            bfs();
            max = Math.max(max, subMax);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]){
                    arrayList.add(new pair(i,j));
                    visit[i][j] = true;
                    findK(depth+1);
                    arrayList.remove(arrayList.size()-1);
                    visit[i][j] = false;
                }
            }
        }
        
        }


    static void bfs() {
        bfsVisit = new boolean[n][n];
        
        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            bfsVisit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!bfsVisit[nx][ny] && hDiff(x, y, nx, ny)) {
                        bfsVisit[nx][ny] = true;
                        q.add(new pair(nx,ny));
                        subMax++;
                    }
                }
            }
        }
    }

    static boolean hDiff(int x, int y, int nx, int ny) {
        int diff = Math.abs(arr[x][y]-arr[nx][ny]);
        if (diff >= u && diff <= d) {
            return true;
        }
        return false;
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










