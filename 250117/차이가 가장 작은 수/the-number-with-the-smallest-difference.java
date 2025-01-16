
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        int [] arr = new int[n];

        //수열 2개. 차이m이상인데 최소
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            set.add(num);
            arr[i] = num;
        }

        //1.3.5
        //차이가 m이상
        //차이배열만들어서 합
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = arr[i];


            if (set.ceiling(x+m)!= null)
                min = Math.min(min, set.ceiling(x+m)-x);

            if (set.floor(x-m)!= null)
                min = Math.min(min, x-set.floor(x-m));

        }

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}