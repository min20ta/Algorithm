
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<pair> meltList = new ArrayList<>();
    static ArrayList<pair> testMeltList = new ArrayList<>();
    static boolean [][] visit;
    static boolean [][] groupVisit;
    static int [][] arr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};
    static Queue<pair> q = new LinkedList<>();
    static int time = 0;
    static int lastMeltCount  = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

            }
        }

        //1 빙하, 0물
        //1초에 한번씩 물에 닿아있는 부분 녹음
        // 시간, 마지막 녹은 빙하그룹개수

        //시간복잡도 계산해보기
        //전부 하나씩 다 검사 하는 방법 - 시간이 관건인듯
        //0그룹찾기
        // 하나씩 다 안하고 이어서 하는 방법- 따로 큐 만들어서 "원래 큐 뒤에 넣어줌"!


        groupVisit = new boolean[n][m];
        do{simulate();
        }while (glacierExist());

        System.out.println(time+" "+ lastMeltCount);


    }
    static void simulate() {
        time++;
        lastMeltCount=0;

        bfs(); //빙하에 둘러쌓여 있지 않은 0그룹

        melt(); //0그룹하나씩 방문하여 녹이기

    }
    static boolean glacierExist() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    static void bfs() {
        visit = new boolean[n][m];
        q.add(new pair(0,0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            pair curPos = q.poll();
            int x = curPos.x;
            int y = curPos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 0 && !visit[nx][ny]) {
                        q.add(new pair(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void melt(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && neighberWater(i,j)){
                    arr[i][j] = 0;
                    lastMeltCount++;
                }
            }
        }
    }

    static boolean neighberWater(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>= 0 && nx < n && ny >= 0 && ny < m){
                if (visit[nx][ny])
                    return true;
            }
        }
        return false;
    }


        static class pair {
        int x;
        int y;

        pair(int x, int y ) {
            this.x =x;
            this.y = y;

        }        }


        }













