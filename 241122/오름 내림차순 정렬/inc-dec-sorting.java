
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        Integer [] arr2 = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);
        Arrays.sort(arr2, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}



