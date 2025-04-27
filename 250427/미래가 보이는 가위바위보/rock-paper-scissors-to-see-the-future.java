
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
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new char[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().charAt(0);
        }

        String shapes = "PHS";
        L = new int[n];
        R = new int[n];
        // L :  0~I까지 동일냈을때 최대이기는 횟수
        for (int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for (int i = 0; i < n; i++) { //p,h,s가 각각 몇개 있는지만 확인
                if (arr[i] == shape)
                    sameCnt ++;
                L[i] = Math.max(L[i], sameCnt);
            }
        }

        //R : i~n-1까지 동일냈을때 최대이기는 횟수
        for (int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for (int i = n-1; i >= 0; i--) {
                if (arr[i] == shape)
                    sameCnt ++;
                R[i] = Math.max(R[i], sameCnt);
            }
        }

  
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            ans = Math.max(ans, L[i] + R[i+1]);
        }
        System.out.println(ans);




        //a가 이길수있는 게임수 최대값



    }



}
