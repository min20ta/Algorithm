
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;
    static boolean noUnder;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> list = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //1*m
        //닫으면 멈툼
        //k~k+m-1
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //밑에서 부터 -> 위에가 뚫려있어야함
        // 아래는 하나라도 1, 위에는 전부 0
        int start = k ; int end = k+m-1; start--; end--;
        loop:
        for (int i = end; i >= start; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0){
                    noUnder = false;
                    if (canDrop(i,j)){
                        drop(i,j);
                        break loop;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        //끝까지 밑으로 떨어질때


        }

        static boolean canDrop(int x, int y) {

            if (!(y + m - 1 >= 0 && y + m - 1 < n)) //블럭이 범위 넘어갈때
                return false;

            for (int i = y; i < y + m; i++) {
                if (arr[x][i] != 0) //자리가 차있을때
                    return false;
            }

            for (int i = y; i < y + m; i++) {
                if (x - 1 >= 0 && arr[x - 1][y] != 0) //위에 블럭이 있을때
                    return false;
                else if (x - 1 < 0)
                    break;

            }


            //아래 블럭
            int under = 0;

            if (x + 1 >= n) {
                noUnder = true;
                return true;
            }

            for (int i = y; i < y + m; i++) {
                if (x + 1 < n && arr[x + 1][i] == 1)
                    under++;
            }

            if (under == 0) {
                noUnder = true;
                return true;
         }
            return true;
        }

        static void drop(int x, int y) {
            if (noUnder) {
                for (int i = y; i < y+m ; i++) {
                    arr[n-1][i] = 1;
                }
            } else {
                for (int i = y; i < y + m; i++) {
                    arr[x][i] = 1;
                }
            }
        }
    }

