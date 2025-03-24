
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
    static int q;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());

        //밀어서 중력, 같은 숫자합
        //연쇄합x, 2개씩 짝
        arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char dir = br.readLine().charAt(0);
        int d = 0;
        if (dir == 'R') d = 0;
        else if (dir == 'L') d = 1;
        else if (dir == 'U') d = 2;
        else d = 3;

        //1. 밀기
        push(d);
        //2. 합
        getPlus(d);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
    static void push(int dir) {


        //R
        if (dir == 0) {
            for (int i = 0; i < 4; i++) {
                //오른쪽부터
                int index = 0;
                int [] temp = new int[4];
                for (int j = 3; j >= 0; j--) {
                    if (arr[i][j] != 0)
                        temp[index++] = arr[i][j];
                }

                index = 0;
                for (int j = 3; j >= 0; j--) {
                    arr[i][j] = temp[index++];
                }
            }
        } else if (dir ==1) {
            //L
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int [] temp = new int[4];
                for (int j = 0; j < 4; j++) {
                    if (arr[i][j] != 0)
                        temp[index++] = arr[i][j];
                }

                index = 0;
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = temp[index++];
                }
            }
        } else if (dir == 2) {
            //U
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int [] temp = new int[4];
                for (int j = 0; j < 4; j++) {
                    if (arr[j][i] != 0)
                        temp[index++] = arr[j][i];
                }

                index = 0;
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = temp[index++];
                }
            }
        }else {
            //D
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int [] temp = new int[4];
                for (int j = 3; j >= 0; j--) {
                    if (arr[j][i] != 0)
                        temp[index++] = arr[j][i];
                }

                index = 0;
                for (int j = 3; j >= 0; j--) {
                    arr[j][i] = temp[index++];
                }
            }
        }

    }

    static void getPlus(int dir) {


        //L
        if (dir == 1) {
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int[] temp = new int[4];
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] != 0 && arr[i][j] == arr[i][j + 1]) {
                        temp[index++] = arr[i][j] * 2;
                        j++;
                    }else
                        temp[index++] = arr[i][j];
                }
                temp[index] = arr[i][3];

                index = 0;
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = temp[index++];
                }
            }
        } else if (dir == 0) {
            //R

            for (int i = 0; i < 4; i++) {
                int index = 0;
                int[] temp = new int[4];
                for (int j = 3; j > 0; j--) {
                    if (arr[i][j] != 0 && arr[i][j] == arr[i][j - 1]) {
                        temp[index++] = arr[i][j] * 2;
                        j--;
                    }else
                        temp[index++] = arr[i][j];
                }
                if (arr[i][1] != arr[i][0])
                    temp[index] = arr[i][0];

                index = 0;
                for (int j = 3; j >= 0; j--) {
                    arr[i][j] = temp[index++];
                }
            }
        } else if (dir == 2) {
            //U
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int[] temp = new int[4];
                for (int j = 0; j < 3; j++) {
                    if (arr[j][i] != 0 && arr[j][i] == arr[j + 1][i]) {
                        temp[index++] = arr[j][i] * 2;
                        j++;
                    }else
                        temp[index++] = arr[j][i];
                }if (temp[index-1] != arr[3][i]*2)
                    temp[index] = arr[3][i];

                index = 0;
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = temp[index++];
                }
            }
        } else {

            //D
            for (int i = 0; i < 4; i++) {
                int index = 0;
                int[] temp = new int[4];
                for (int j = 3; j > 0; j--) {
                    if (arr[j][i] != 0 && arr[j][i] == arr[j - 1][i]) {
                        temp[index++] = arr[j][i] * 2;
                        j--;
                    }else
                        temp[index++] = arr[j][i];
                }if (temp[index-1] != arr[0][i]*2)
                    temp[index] = arr[0][i];

                index = 0;
                for (int j = 3; j >= 0; j--) {
                    arr[j][i] = temp[index++];
                }
            }
        }
    }

}