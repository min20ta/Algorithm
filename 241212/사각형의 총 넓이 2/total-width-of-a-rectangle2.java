
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) + 100;
        int y1 = Integer.parseInt(st.nextToken()) + 100;
        int x2 = Integer.parseInt(st.nextToken()) + 100;
        int y2 = Integer.parseInt(st.nextToken()) + 100;


        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken()) + 100;
        int b1 = Integer.parseInt(st.nextToken()) + 100;
        int a2 = Integer.parseInt(st.nextToken()) + 100;
        int b2 = Integer.parseInt(st.nextToken()) + 100;

        int [][] arr1 = new int[201][201];

        for (int i = x1 ; i < x2 ; i++) {
            for (int j = y1 ; j < y2 ; j++) {
                arr1[i][j]= 1;
            }
        }

        for (int i = a1 ; i < a2 ; i++) {
            for (int j = b1 ; j < b2 ; j++) {
                arr1[i][j]= 1;
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





