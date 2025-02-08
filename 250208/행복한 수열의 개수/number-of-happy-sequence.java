
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

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        //연속 m개 동일원소나오는 수열
        //각행, 열 검사

        //행검사
        int happy = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            boolean check = false;
            for (int j = 0; j < n-1; j++) {
                if (arr[i][j] != arr[i][j+1]) {
                    if (sum >= m) {
                        happy++;
                        check = true;
                        break;
                    }
                    sum = 0;
                }
                sum++;

            }
            if (!check && sum >= m) {
                happy++;
            }
        }
//        System.out.println(happy);

        //열검사

        for (int i = 0; i < n; i++) {
            int sum = 0;
            boolean check = false;
            for (int j = 0; j < n-1; j++) {
                if (arr[j][i] != arr[j+1][i]) {
                    if (sum >= m) {
                        happy++;
                        check = true;
                        break;
                    }
                    sum = 0;
                }
                sum++;
            }
            if (!check && sum >= m) {
                happy++;
            }
        }

        System.out.println(happy);

    }







}


