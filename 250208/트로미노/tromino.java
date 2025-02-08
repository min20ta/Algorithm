
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
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
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        //연속 m개 동일원소나오는 수열
        //각행, 열 검사

        //가로3
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=  m-3; j++) {

                int sum = 0;
                for (int k = j; k < j+3 ; k++) {
                    sum+= arr[i][k];
                }
                max = Math.max(max, sum);
            }
        }
        

        //세로3
        for (int i = 0; i <= n-3; i++) {
            for (int j = 0; j < m; j++) {

                int sum = 0;
                for (int k = i; k < i+3 ; k++) {
                    sum+= arr[k][j];
                }
                max = Math.max(max, sum);
            }
        }

        //사각-제일작은조각
        for (int i = 0; i <= n-2; i++) {
            for (int j = 0; j <= m-2; j++) {
                int min = Integer.MAX_VALUE;
                int sum = 0;

                for (int k = i; k < i+2 ; k++) {
                    for (int l = j; l < j+2; l++) {
                        sum+= arr[k][l];
                        min = Math.min(min, arr[k][l]);
                    }
                }
                max = Math.max(max, sum-min);
            }
        }


        System.out.println(max);

    }







}


