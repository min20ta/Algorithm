
import java.util.*;
import java.io.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (i >= 1 && arr[i] > t) {
                count++;
            }else {
                count = 0;
            }
            max = Math.max(max, count);
        }

            System.out.println(max);

    }
}
