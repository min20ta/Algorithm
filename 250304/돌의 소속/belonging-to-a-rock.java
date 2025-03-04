import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int k;
    static int q;

    static int sumA = 0;
    static int sumB = 0;
    static int sumC = 0;
    static int[] dpA ;
    static int []dpB ;
    static int [] dpC;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int [] a = new int[100001];
        int [] b = new int[100001];
        int [] c = new int[100001];


        dpA = new int[100001];
        dpB = new int[100001];
        dpC = new int[100001];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 1)
                a[i] = 1;
            else if (num == 2)
                b[i] = 1;
            else if (num == 3)
                c[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
                dpA[i] = dpA[i-1] + a[i] ;
                dpB[i] = dpB[i-1] + b[i] ;
                dpC[i] = dpC[i-1] + c[i] ;
            }



        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) {
                sumA = dpA[end];
                sumB = dpB[end];
                sumC = dpC[end];
            } else {
                sumA = dpA[end] - dpA[start - 1];
                sumB = dpB[end] - dpB[start - 1];
                sumC = dpC[end] - dpC[start - 1];
            }
            System.out.println(sumA+" "+sumB+" "+sumC);
        }



    }
    }

















