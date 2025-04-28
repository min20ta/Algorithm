
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
    static int [] L;
    static int [] R;

    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        L = new int[n]; //i까지 중 최댓값
        R = new int[n]; //i~끝 중 최대값

        L[0] = arr[0];
        for (int i = 1; i < n ; i++) {
            L[i] = Math.max(L[i-1],arr[i]);
        }
        
        R[n-1] = arr[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            R[i] = Math.max(R[i+1],arr[i]);
        }

        int ans = 0;
        for (int i = 2; i < n-2; i++) {
            ans = Math.max(ans, L[i-2]+arr[i]+R[i+2]);
        }

        System.out.println(ans);

    }


}



