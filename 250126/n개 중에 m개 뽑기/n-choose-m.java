
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static int [] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //인자사용은 특정 수의 개수 m개 필요시 편리
        find(0);
    }

    static void find(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= n ; i++) {
            if (arrayList.isEmpty() || arrayList.get(arrayList.size()-1) < i){
                arrayList.add(i);
                find(depth+1);
                arrayList.remove(arrayList.size()-1);
            }
        }
    }



}



