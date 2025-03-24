
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
    static boolean haveBomb;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //밀어서 중력, 같은 숫자합
        //연쇄합x, 2개씩 짝
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (k-- > 0) {
            //1. 터지기. 열기준 m개이상, 중력, -> 반복
            haveBomb = true;
            while (haveBomb) {
                haveBomb = false;
                getBomb();
                push();
            }
            //2. 회전
           rotate();
            push();
        }

        //k번후에도 터질거 있다면 터트리기
        haveBomb = true;
        while (haveBomb) {
            haveBomb = false;
            getBomb();
            push();
        }
      

        int bomb = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0)
                    bomb++;
            }
        }

        System.out.println(bomb);

    }
    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void getBomb() {
        for (int col = 0; col < n; col++) {
            int count = 1;

            for (int row = 1; row < n; row++) {
                if (arr[row][col]!=0 && arr[row][col] == arr[row-1][col]){
                    int num = arr[row][col];
                    count++;
                    int end = n-1;

                    for (int i = row; i < n; i++) {
                        if (arr[i][col] == num){
                            count++;
                        }else{
                            end = i-1;
                            break;
                        }
                    }

                    if (count >= m) {
                        for (int i = row - 1; i <= end; i++) {
                            arr[i][col] = 0;
                        }
                        haveBomb = true;
                    }
                    row = end;
                    count = 1;
                }
            }

        }
    }

    static void push() {

        //D
        for (int i = 0; i < n; i++) {
            int index = 0;
            int [] temp = new int[n];
            for (int j = n-1; j >= 0; j--) {
                if (arr[j][i] != 0)
                    temp[index++] = arr[j][i];
            }

            index = 0;
            for (int j = n-1; j >= 0; j--) {
                arr[j][i] = temp[index++];
            }
        }
    }

    static void rotate() {
        int [][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n-j-1][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }




}