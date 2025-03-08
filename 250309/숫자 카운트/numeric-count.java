
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        pair [] arr = new pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new pair(num,a,b);
        }


        int count = 0;
            for (int j = 1; j <=9 ; j++) {
                for (int l = 1; l <= 9 ; l++) {
                    for (int o = 1; o <= 9 ; o++) {

                        boolean ans = true;
                        for (int i = 0; i < n; i++) {
                            int first = 0;
                            int second = 0;
                            pair p = arr[i];
                            String num = p.n +"";

                            if (num.charAt(0) == (char)(j+'0'))
                                first++;
                            if (num.charAt(1) == (char)(l+'0'))
                                first++;
                            if (num.charAt(2) == (char)(o+'0'))
                                first++;

                            if (num.charAt(0) == (char)(l+'0')
                                    ||num.charAt(0) == (char)(o+'0') )
                                second++;
                            if (num.charAt(1) == (char)(j+'0')
                                    ||num.charAt(1) == (char)(o+'0'))
                                second++;
                            if (num.charAt(2) == (char)(l+'0')
                                    ||num.charAt(2) == (char)(j+'0'))
                                second++;

                           // System.out.println(j+""+l+""+o+" "+num +" "+ first+" "+second);
                            if (!(first == p.a && second == p.b)) {
                                ans = false;
                                break;
                            }
                        }
                        if (ans)
                            count++;
                }
            }
        }

        System.out.println(count);




        }



static class pair{
        int n;
        int a;
        int b;

        pair(int n, int a, int b){
            this.n = n;
            this.a = a;
            this.b = b;
        }
}
    }











