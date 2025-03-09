
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
       String strA = br.readLine();
       String strB = br.readLine();
        int num = 0;
       while (strA.indexOf(strB) != -1) {
           num = strA.indexOf(strB);

           StringBuilder sb = new StringBuilder(strA);
           sb.delete(num,num+strB.length());
           strA = sb.toString();
       }


        System.out.println(strA);

    }




    }










