
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] =   Integer.parseInt(st.nextToken());
            arr[i][1] =   Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int Amin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int Amax = Integer.MIN_VALUE;
        int [] list = new int[n];
        int p = 0;

        for (int i = 0; i < n; i++) {

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;


            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                min = Math.min(min, arr[j][0]);
                max = Math.max(max, arr[j][1]);
            }


            list[p] = max-min;
            p++;

        }
        Arrays.sort(list);
        System.out.println(list[0]);



    }
}
