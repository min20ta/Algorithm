
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int [] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (arr[i] != arr2[i]) {
                System.out.println("No");
                flag = false;
                break;
            }
        }

        if (flag)
            System.out.println("Yes");
    }
}



