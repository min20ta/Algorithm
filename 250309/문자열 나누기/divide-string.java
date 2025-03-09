
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int [][] arr;
    static int [][] dp;

    static int [] a;
    static int [] b;
    static TreeMap<Integer,Integer> map = new TreeMap<>();
    static TreeSet<Integer> nums = new TreeSet<>();



    static final int MAX_NUM = 100000;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String str = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            str += st.nextToken();
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count < 5) {
                count++;
                System.out.print(str.charAt(i));
            }else {
                count = 0;
                i--;
                System.out.println();
            }
        }
//        if (str.length()%5!=0) {
//            int end = str.length()%5;
//            for (int i = str.length()-end; i < str.length() ; i++) {
//                System.out.print(str.charAt(i));
//            }
//        }



    }




    }











