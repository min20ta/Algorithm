
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static long k;
    static int idx = 0;
    static int root;
    static boolean[] visit;
    static int edgeCount = 0;
    static int nodeCount = 0;
    static boolean [] finish;
    static int [][] arr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static Set<Integer>set = new HashSet<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i <= n-3; i++) {
            for (int j = 0; j <= n-3; j++) {
                int sum = 0;

                for (int l = i; l < i+3 ; l++) {
                    for (int m = j; m < j+3 ; m++) {
                        if (arr[l][m] == 1)
                            sum++;
                    }
                }

                max = Math.max(max, sum);
            }
        }

        System.out.println(max);

    }







}


