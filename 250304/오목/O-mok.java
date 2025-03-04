import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int k;
    static int q;

    static int sumA = 0;
    static int sumB = 0;
    static int sumC = 0;
    static int[] dpA ;
    static int []dpB ;
    static int [][] arr;
    static int middleX;
    static int middleY;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        q = Integer.parseInt(st.nextToken());

        arr = new int[20][20];
        for (int i = 1; i <= 19 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean goal = false;
        int ans = 0;
        for (int i = 1; i <= 19 ; i++) {
            for (int j = 1; j <= 19 ; j++) {
                if (arr[i][j]!= 0 && find(i,j, arr[i][j])){
                    ans = arr[i][j];
                    goal = true;
                    break;
                }
            }
        }

        if (goal) {
            System.out.println(ans);
            System.out.println(middleX+" "+middleY);
        } else {
            System.out.println(0);
        }






    }
    static boolean find(int x, int y, int color) {
        boolean goal = true;

        if (x + 4 >= 1 && x + 4 <= 19) {
            for (int i = x; i < x + 5; i++) {
                if (arr[i][y] != color) {
                    goal = false;
                    break;
                }
            }
            if (goal) {
                middleX = x+2;
                middleY = y;
                return true;
            }
        }

        if (y + 4 >=1 && y+ 4 <= 19) {
            goal = true;
            for (int i = y; i < y + 5; i++) {
                if (arr[x][i] != color) {
                    goal = false;
                    break;
                }
            }
            if (goal) {
                middleX = x;
                middleY = y+2;
                return true;
            }
        }

        if (x+4 >= 1 && x + 4 <= 19 && y+4 >= 1 && y+4 <=19) {
            goal = true;
            for (int i = 0; i < 5; i++) {
                if (arr[x + i][y + i] != color) {
                    goal = false;
                    break;
                }
            }
            if (goal) {
                middleX = x+2;
                middleY = y+2;
                return true;
            }
        }

        if (x-4 >= 1 && x - 4 <= 19 && y-4 >= 1 && y-4 <=19) {
            goal = true;
            for (int i = 0; i < 5; i++) {
                if (arr[x - i][y - i] != color) {
                    goal = false;
                    break;
                }
            }
            if (goal) {
                middleX = x-2;
                middleY = y-2;
                return true;
            }
        }

        return false;

    }

    }











