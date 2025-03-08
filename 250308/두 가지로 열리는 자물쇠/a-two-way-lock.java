
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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                for (int l = 1; l <=n ;l++) {
                    boolean ans = false;

                    if (Math.min(Math.abs(i-a1),n-Math.abs(i-a1))<=2
                            &&Math.min(Math.abs(j-b1),n- Math.abs(j-b1))<=2
                            && Math.min(Math.abs(l-c1),n- Math.abs(l-c1))<=2)
                        ans = true;
                   else if (Math.min(Math.abs(i-a2),n- Math.abs(i-a2))<=2
                            &&Math.min(Math.abs(j-b2),n- Math.abs(j-b2))<=2
                            && Math.min(Math.abs(l-c2),n- Math.abs(l-c2))<=2)
                        ans = true;

                    if (ans){
                        count++;
                      //  System.out.println(i+" "+j+ " "+l);
                    }
                }
            }
        }
        System.out.println(count);


        //1~N 3자리


        }




    }






