
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[][] arr;
    static int[][] dp;

    static int[] a;
    static int[] b;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static TreeSet<Integer> nums = new TreeSet<>();


    static final int MAX_NUM = 100000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());


        char [] a = br.readLine().toCharArray();
        String b = br.readLine();
        int len = a.length-1;

        int count = 0;
        boolean ans = false;
        while (len-- > 0) {
            char temp = a[a.length - 1];
            for (int i = a.length-2; i >= 0; i--) {
                a[i + 1] = a[i];
            }
            a[0] = temp;

            count++;

          //  System.out.println(String.valueOf(a));
            if (String.valueOf(a).equals(b)) {
                System.out.println(count);
                ans = true;
                break;
            }

        }
        if (!ans)
            System.out.println(-1);
    }
}



