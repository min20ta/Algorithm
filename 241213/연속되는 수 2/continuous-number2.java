
import java.util.*;
import java.io.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[1001];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (i == 0 || arr[i] != arr[i-1]) {
                max = Math.max(max, count);
                count = 1;
            }else {
                count++;
            }
        }


        System.out.println(max);

    }
}
