
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static int [] arr;
    static int [] y;
    static int [] L;
    static int [] R;


    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        int wifi = 0;
        boolean prevIsPeople = false;
        int where = 0;
        if (arr[0] == 1) {where += m; prevIsPeople = true;}
        if (m == 0) wifi++;

        for (int i = where; i < n; i++) {
            if (arr[i] == 1) {
                if (!prevIsPeople) {
                    prevIsPeople = true;
                    i += m-1; //어케 처리하지
                }else {
                    wifi++;
                    i += m;
                    prevIsPeople = false;
                }
            }else {
                if (!prevIsPeople) {
                    prevIsPeople = true;
                    wifi++;
                }
            }

        }
        System.out.println(wifi);






    }



}



