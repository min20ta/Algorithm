
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1)
                    ans++;
            }
        } else if (m >= n) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    ans = 1;
                    break;
                }
            }
        } else {
            for (int i = m; i < n; i++) {
                //지정자리 왼 :
                int seat = arr[i];
                arr[i] = 0;
                int leftSum = 0;

                for (int j = i - m; j < i; j++) {
                    leftSum += arr[j];
                    arr[j] = 0;
                }
                for (int j = i+1 ; j <= i+m ; j++) {
                    arr[j] = 0;
                }

                if (leftSum == 0) {
                    continue;
                } else if (leftSum > 0) {
                    ans++;
                    i += m+m ;

                }

                // 커버하지 못하고 남는 거


            }

            for (int i = 0; i < n; i++) {
                if (arr[i] == 1)
                    ans++;
            }
        }


        System.out.println(ans);






    }
}



