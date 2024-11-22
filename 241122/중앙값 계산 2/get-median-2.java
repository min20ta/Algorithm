
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if ((i + 1) % 2 == 1) {
                Arrays.sort(arr, 0, i + 1);
                list.add(arr[(i + 1) / 2]);
            }
        }

        for (int a : list) {
            System.out.print(a+" ");
        }
    }


}




