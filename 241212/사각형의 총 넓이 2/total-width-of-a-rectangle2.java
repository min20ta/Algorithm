
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] arr1 = new int[201][201];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;


            for (int k = x1 ; k < x2 ; k++) {
                for (int j = y1 ; j < y2 ; j++) {
                    arr1[k][j]= 1;
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





