
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j <=x2 ; j++) {
                arr[j]++;
            }

        }
        Arrays.sort(arr);

        System.out.println(arr[100]);








    }


}

