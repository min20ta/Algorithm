
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int [][] arr1 = new int[2001][2001];


            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1000;
            int y1  = Integer.parseInt(st.nextToken()) + 1000;
            int x2  = Integer.parseInt(st.nextToken()) + 1000;
            int y2  = Integer.parseInt(st.nextToken()) + 1000;

            for (int p = x1; p < x2 ; p++) {
                for (int j = y1; j < y2 ; j++) {
                    arr1[p][j] = 1;
                }

            }

        st = new StringTokenizer(br.readLine());
        int x11 = Integer.parseInt(st.nextToken()) + 1000;
        int y11  = Integer.parseInt(st.nextToken()) + 1000;
        int x22  = Integer.parseInt(st.nextToken()) + 1000;
        int y22  = Integer.parseInt(st.nextToken()) + 1000;

        for (int p = x11; p < x22 ; p++) {
            for (int j = y11; j < y22 ; j++) {
                arr1[p][j] = 0;
            }

        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <=2000; j++) {
                if (arr1[i][j] == 1) {
                    minX = Math.min(i,minX);
                    minY = Math.min(j,minY);
                    maxX = Math.max(i,maxX);
                    maxY = Math.max(j,maxY);
                }
            }
        }

        System.out.println((maxX+1-minX)*(maxY+1-minY));

    }


}





