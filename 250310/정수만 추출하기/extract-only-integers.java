
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num1 = "";
        String num2 = "";
        String str = st.nextToken();
        String str2 = st.nextToken();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) <= '9' && '0' <= str.charAt(j)) {
                num1 += str.charAt(j);
            }else
                break;
        }

        for (int j = 0; j < str2.length(); j++) {
            if (str2.charAt(j) <= '9' && '0' <= str2.charAt(j)) {
                num2 += str2.charAt(j);
            }else
                break;
        }

        System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
    }
}