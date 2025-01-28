
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<pair> meltList = new ArrayList<>();
    static boolean [][] visit;
    static int [][] arr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={1,0,-1,0};
    static Queue<pair> q = new LinkedList<>();
    static int time = 0;
    static int countAll = 0;


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

                if (num == 0)
                    q.add(new pair(i,j));
            }
        }

        //1 빙하, 0물
        //1초에 한번씩 물에 닿아있는 부분 녹음
        // 시간, 마지막 녹은 빙하그룹개수
        visit = new boolean[n][m];


        while(true){
            countAll = 0;
            bfs();
            melt();

            boolean flag = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j]) {
                        if (arr[i][j] == 0){
                            q.add(new pair(i,j));
                            flag = false;
                        }
                    }
                }
            }

            if (flag)
                break;

            time++;
            arrayList.add(countAll);

        }

        System.out.println(time+" "+ arrayList.get(arrayList.size()-1));
    }


        static void bfs() {


        while (!q.isEmpty()){
            pair p = q.poll();
            int ax = p.x;
            int ay = p.y;
            int count = 0;
           // System.out.println("q: "+ax+" "+ay+" ");
                //4방 검사
                loop:
                for (int i = 0; i < 4; i++) {

                    int x = ax;
                    int y = ay;

                    while (true) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (arr[nx][ny] == 1){
                                count++;
                                break;
                            }
                        }else
                            break loop;

                        x = nx;
                        y = ny;
                    }
            }
            //4방 아니라면
            if (count != 4) {
                meltList.add(new pair(p.x, p.y));
            }
        }

        }

        static void melt() {

            for (int k = 0; k < meltList.size(); k++) {
                pair p = meltList.get(k);

                visit[p.x][p.y] = true;
                for (int i = 0; i < 4; i++) {

                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (arr[nx][ny] == 1) {
                            arr[nx][ny] = 0;
                            //System.out.println("melt: "+ nx + " " + ny + " ");
                            countAll++;
                        }
                    }
                }
            }

            meltList.clear();
        }



        static class pair {
        int x;
        int y;

        pair(int x, int y ) {
            this.x =x;
            this.y = y;

        }        }


        }










