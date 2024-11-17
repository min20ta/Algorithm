
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        if (m == 0) {
            for (int i = 0 ; i < n ; i++) {
                if (arr[i] == 1)
                    ans++;
            }
        }else {
            for (int i = m; i < n; i++) {
                //지정자리 왼 :
                int seat = arr[i];

                int leftSum = 0;
                for (int j = i - m; j < i; j++) {
                    leftSum += arr[j];
                }
                if (leftSum == 0) {
                    continue;
                } else if (leftSum > 0) {
                    ans++;
                    i += m + m;
                }

            }
        }

        System.out.println(ans);






    }
}


