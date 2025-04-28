
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
    static char [] arr;
    static int [] y;
    static int [] L;
    static int [] R;


    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }


        int ans =0;
        for (int i = n-1; i > 0 ; i--) {
            if (list.get(i) < list.get(i-1)){
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }





}



