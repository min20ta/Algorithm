import java.util.*;
import java.io.*;


public class Main {
    static int [] arr ;
    static int [] temp ;
    static int endOfArray ;
    static int idx = 0;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        char c = br.readLine().charAt(0);
        int [][] temp = new int[4][4];
        int [][] temp2 = new int[4][4];

        if (c == 'R') {
            //밀기
            for (int i = 0; i < 4; i++) {
                int index = 3;
                for (int j = 3; j >= 0; j--) {
                    if (grid[i][j]!=0) {
                        temp[i][index--] = grid[i][j];
                    }
                }
            }
            //중력
            for (int i = 0; i < 4; i++) {
                int index = 3;
                for (int j = 3; j >= 0 ; j--) {
                    if (j == 0){
                        temp2[i][index--] = temp[i][j];
                        continue;
                    }
                    if (temp[i][j] == temp[i][j-1]){
                        temp2[i][index--] = 2*temp[i][j];
                        j--;
                    }else
                        temp2[i][index--] = temp[i][j];
                }
            }
        }else if (c == 'L'){
            //밀기
            for (int i = 0; i < 4; i++) {
                int index = 0;
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j]!=0) {
                        temp[i][index++] = grid[i][j];
                    }
                }
            }
            //중력
            for (int i = 0; i < 4; i++) {
                int index = 0;
                for (int j = 0; j < 4 ; j++) {
                    if (j == 3){
                        temp2[i][index++] = temp[i][j];
                        continue;
                    }
                    if (temp[i][j] == temp[i][j+1]){
                        temp2[i][index++] = 2*temp[i][j];
                        j++;
                    }else
                        temp2[i][index++] = temp[i][j];
                }
            }
        }else if (c == 'U') {
            //밀기
            for (int i = 0; i < 4; i++) {
                int index = 0;
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j]!=0) {
                        temp[index++][j] = grid[i][j];
                    }
                }
            }
            //중력
            for (int j = 0; j < 4; j++) {
                int index = 0;
                for (int i = 0; i < 4 ; i++) {
                    if (i == 3){
                        temp2[index++][j] = temp[i][j];
                        continue;
                    }
                    if (temp[i][j] == temp[i+1][j]){
                        temp2[index++][j] = 2*temp[i][j];
                        i++;
                    }else
                        temp2[index++][j] = temp[i][j];
                }
            }
        }else {
            //밀기
            for (int i = 0; i < 4; i++) {
                int index = 3;
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j]!=0) {
                        temp[index--][j] = grid[i][j];
                    }
                }
            }
            //중력
            for (int j = 0; j < 4; j++) {
                int index = 3;
                for (int i = 3; i >= 0 ; i--) {
                    if (i == 0){
                        temp2[index--][j] = 2*temp[i][j];
                        continue;
                    }
                    if (temp[i][j] == temp[i-1][j]){
                        temp2[index--][j] = 2*temp[i][j];
                        i++;
                    }else
                        temp2[index--][j] = temp[i][j];
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int a : temp2[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
        //합치기

}
