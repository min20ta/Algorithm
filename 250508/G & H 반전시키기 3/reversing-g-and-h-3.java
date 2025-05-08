


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int c;
    static int ans;
    static int [] arr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String str1 = br.readLine();
        String str2 = br.readLine();
        char [] c1 = str1.toCharArray();
        char [] c2 = str2.toCharArray();

        int count = 0;
        //두번 바꿀필요x
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
            if (count > 4 || (i>=1 && c1[i-1] != c2[i-1] && c1[i] == c2[i])) {
                ans++;
                count -= 4;
            }
        }


        System.out.println(ans);


    }



}




