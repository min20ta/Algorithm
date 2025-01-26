
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static int [] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        //인자사용은 특정 수의 개수 m개 필요시 편리
        find(0,0);
        System.out.println(max);
    }

    static void find(int depth, int ans) {
        if (depth == m) {
            max = Math.max(max, ans);
            return;
        }

        for (int i = 1; i <= n ; i++) {
                find(depth+1, ans^arr[i]);

        }
    }



}



