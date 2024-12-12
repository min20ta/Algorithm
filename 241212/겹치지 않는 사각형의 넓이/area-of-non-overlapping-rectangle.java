
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int [][] arr1 = new int[2001][2001];



            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1000;
            int y1 = Integer.parseInt(st.nextToken()) + 1000;
            int x2 = Integer.parseInt(st.nextToken()) + 1000;
            int y2 = Integer.parseInt(st.nextToken()) + 1000;


            for (int k = x1 ; k < x2 ; k++) {
                for (int j = y1 ; j < y2 ; j++) {
                    arr1[k][j]= 1;
                }
            }

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken()) + 1000;
        int b1 = Integer.parseInt(st.nextToken()) + 1000;
        int a2 = Integer.parseInt(st.nextToken()) + 1000;
        int b2 = Integer.parseInt(st.nextToken()) + 1000;


        for (int k = a1 ; k < a2 ; k++) {
            for (int j = b1 ; j < b2 ; j++) {
                arr1[k][j]= 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken()) + 1000;
        int q1 = Integer.parseInt(st.nextToken()) + 1000;
        int p2 = Integer.parseInt(st.nextToken()) + 1000;
        int q2 = Integer.parseInt(st.nextToken()) + 1000;


        for (int k = p1 ; k < p2 ; k++) {
            for (int j = q1 ; j < q2 ; j++) {
                arr1[k][j]= 0;
            }
        }



        int sum = 0;
        for (int i = 0 ;i <= 2000 ; i++) {
            for (int j = 0; j <= 2000 ; j++) {
                if (arr1[i][j] == 1)
                    sum++;
            }
        }

        System.out.println(sum);







    }


}






