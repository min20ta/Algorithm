


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
    static int [][] arr;
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

        //구간을 겹칠 필요가 없다
        String str1 = br.readLine();
        String str2 = br.readLine();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        //다른 덩어리 개수
        int start = 0;
        int end = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) {
                start = i;
                for (int j = start; j < n ; j++) {
                    if (c1[j] == c2[j] || (j == n-1 && c1[j] != c2[j])) {
                        end = j-1;
                        count++;
                        i = end;
                        break;
                    }
                }
            }

        }

        System.out.println(count);


    }



}



