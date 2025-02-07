
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int k;
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

        left = new int[n+1];
        right = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            left[i] = x;
            right[i] = y;
        }


        k = Integer.parseInt(br.readLine());

        int node = 1;
        int ans = 0;
        arr = new int[n+1];
        while (k-- > 0) {

           if (left[node] > 0 && right[node] == -1)
               node = left[node];
           else if (left[node] == -1 && right[node] > 0)
               node = right[node];
           else if (left[node] == -1 && right[node] == -1){
                arr[node]++;
                ans = node;
           }else if (left[node] > 0 && right[node] > 0) {
               int leftSum = 0;
               int rightSum = 0;
               int idx = node;

               while(true) {
                   if (left[idx] == -1)
                       break;
                   leftSum+=arr[idx];
                   idx = left[idx];
               }

               idx = node;
               while(true) {
                   if (right[idx] == -1)
                       break;
                   rightSum+=arr[idx];
                   idx = right[idx];
               }

               if (leftSum <= rightSum)
                   node = left[node];
               else
                   node = right[node];
           }

        }
        
        System.out.println(ans);


        }






}






