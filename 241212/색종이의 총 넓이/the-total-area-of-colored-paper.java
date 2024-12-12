import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int [][] arr1 = new int[201][201];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 100;
            int y = Integer.parseInt(st.nextToken()) + 100;

            for (int p = x; p < x+8 ; p++) {
                for (int j = y; j < y + 8; j++) {
                    arr1[p][j] = 1;
                }

            }

        }

        int sum = 0;
        for (int i = 0 ;i <= 200 ; i++) {
            for (int j = 0; j <= 200 ; j++) {
                if (arr1[i][j] == 1)
                    sum++;
            }
        }

        System.out.println(sum);







    }


}




