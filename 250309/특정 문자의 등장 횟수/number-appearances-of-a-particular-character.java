
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
        String str = br.readLine();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == 'e' && str.charAt(i+1) =='e'){
                count1++;
            }else if (str.charAt(i) == 'e' && str.charAt(i+1) =='b'){
                count2++;
            }
        }

        System.out.println(count1+" "+count2);



    }




    }











