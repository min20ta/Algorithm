import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[][] grid;
    static int[][] temp;
    static int endOfArray;
    static int idx = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int endIndex;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //열기준 연속 m 폭발
        //중력
        //시계방향 회전
        //중력
        //k번 반복후에 남아있다면 회전제외 폭발 및 중력
        //남아있는 수
        while (k-- > 0) {
            bombing();
            gravity();
            rotateAndGravity();
        }

        while (isBombLeft()) {
            bombing();
            gravity();

        }

        int ans =countBomb();

        System.out.println(ans);

    }

    //폭탄후 밑으로
    static void bombing() {
        int count = 1;
        int start = 0;

        for (int j = 0; j < n; j++) {
            count = 1;
            start = 0;
            for (int i = 1; i < n; i++) {
                if (map[i][j] == map[i-1][j] && map[i][j] !=0)
                    count++;
                else if (map[i][j] != map[i-1][j]){
                    if (count >= m) {
                        for (int p = start; p < i; p++) {
                                map[p][j] = 0;
                            }
                    }
                    start = i;
                    count = 1;
                }
            }
            if (count >= m) {
                for (int p = start; p < n; p++) {
                    map[p][j] = 0;
                }
            }

        }

//        //다시 옮기기
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

    }

    static void gravity() {
        temp = new int[n][n];

        for (int j = 0; j < n; j++) {
            int index = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    temp[index--][j] = map[i][j];
                }
            }
        }

        //다시 옮기기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = temp[i][j];
//                System.out.print(map[i][j]+" ");
            }
//            System.out.println();
        }
    }

    static void rotateAndGravity() {
        temp = new int[n][n];

        for (int j = n - 1; j >= 0; j--) {
            int index = n-1;
            for (int i = n - 1; i >= 0; i--) {
                if (map[j][i] != 0) {
                    temp[index--][n-1-j] = map[j][i];
                }
            }
        }

        //다시 옮기기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = temp[i][j];
//                System.out.print(map[i][j]+" ");
            }
//            System.out.println();
        }
//        System.out.println();
    }

    static boolean isBombLeft() {
        int count = 1;

        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n-1; j++) {
                if (map[j][i] != 0 &&
                        map[j][i] == map[j + 1][i]) {
                    count++;
                } else {
                    if (count >= m){
                        return true;}
                    count = 1;
                }
            }
            if (count >= m)
                return true;
        }
        return false;
    }

    static int countBomb() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]!=0)
                    count++;
            }
        }
        return count;
    }
}
