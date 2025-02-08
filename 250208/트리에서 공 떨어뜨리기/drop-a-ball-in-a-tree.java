
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
    static int [] right;
    static int [] left;
    static int [] arr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int subMax = Integer.MIN_VALUE;
    static Set<Integer>set = new HashSet<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        left = new int[2*n+1];
        right = new int[2*n+1];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            left[i] = x;
            right[i] = y;
        }


        k = Long.parseLong(br.readLine());
        //값이 클때는 시뮬레이션 불가능

        int node = 1;
        int idx = 1;
        int ans = 0;

        while (k>0) {

            if (left[node] == -1 && right[node] == -1){
                ans = node;
                break;
            }

            if (left[node] > 0 && right[node] == -1)
                node = left[node];
            else if (left[node] == -1 && right[node] > 0)
                node = right[node];
            else if (k % 2 != 0){ //홀수일때 -> 왼쪽 서브트리
                    node = left[node];
                    k = k/2+1;
            }else {
                    node = right[node];
                    k /= 2;
            }

        }
        System.out.println(ans);


    }







}
