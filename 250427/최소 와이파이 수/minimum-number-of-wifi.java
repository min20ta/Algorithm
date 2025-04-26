
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
        int count = -1;

        if (n <= m) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1){
                    wifi = 1;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) count++;

                if (count == m) {
                    wifi++;
                    count = -1;
                    i += m;
                }
            }
        }
        System.out.println(wifi);






    }



}








