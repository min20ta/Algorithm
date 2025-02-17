import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] map2;
    static int[][] dir;
    static int[][] dir2;
    static int idx = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int n;
    static int m;
    static int t;
    static int stop = 0;
    static int prev;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<int [][]> list = new ArrayList<>();
    static ArrayList<int [][]> dirList = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            dir = new int[n][n];


            list = new ArrayList<>();
            dirList = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());x--;
                int y = Integer.parseInt(st.nextToken());y--;
                char d = st.nextToken().charAt(0);

                int direction = 0;
                if (d == 'L') direction = 0;
                else if (d == 'D') direction = 1;
                else if (d == 'R') direction = 2;
                else if (d == 'U') direction = 3;

                map[x][y] = 1;
                dir[x][y] = direction;
            }


            //움직인 후 , 저장전에 확인해야함
            do{
                map2 = new int[n][n];
                dir2 = new int[n][n];
                saveInList();
                move();
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        System.out.print(map[i][j]+" ("+dir[i][j]+") ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }while (!checkMap());

            System.out.println(count());

        }

    }


    static void move() {

        //1초
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int nx = i + dx[dir[i][j]];
                    int ny = j + dy[dir[i][j]];

                    if (!(nx>= 0 && nx < n && ny >= 0 && ny < n)) {//벽 부딪힐때
                        if (dir[i][j] == 0) dir2[i][j] = 2;
                        else if (dir[i][j] == 1) dir2[i][j] = 3;
                        else if (dir[i][j] == 2) dir2[i][j] = 0;
                        else if (dir[i][j] == 3) dir2[i][j] = 1;

                        map2[i][j]++;
                    }else {
                        dir2[nx][ny] = dir[i][j];
                        map2[nx][ny]++;
                    }

                    map[i][j] = 0;

                }
            }
        }
        //충돌확인
        checkBomb();
        //dir담은 배열 다시 복구
        replaceDir();

    }

    static void checkBomb() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j] >= 2){
                    map2[i][j] = 0;
                    dir2[i][j] = 0;
                }
            }
        }
    }

    static void replaceDir() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dir[i][j] = dir2[i][j];
                map[i][j] = map2[i][j];
            }
        }
    }

    static void saveInList() {
        int [][] saveArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                saveArr[i][j] = map[i][j];
            }
        }
        list.add(saveArr);

        int [][] saveDirArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                saveDirArr[i][j] = dir[i][j];
            }
        }
        dirList.add(saveDirArr);
    }

    static boolean checkMap() {
        //이전 맵상태와 같은 것이 있는지
        for (int i = 0; i < list.size() ; i++) {
            int [][] arr = list.get(i);
            int [][] dirArr = dirList.get(i);
            boolean check = true;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!(arr[j][k] == map[j][k] && dirArr[j][k] == dir[j][k])) {
                        check = false;
                        break;
                    }
                }
            }

            if (check)
                return true;
        }
        return false;
    }

    static int count() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    static class pair {
        int x;
        int y;
        int d;


        pair(int x, int y, int d) {
            this.x =x;
            this.y = y;
            this.d = d;



        }
        }
}

