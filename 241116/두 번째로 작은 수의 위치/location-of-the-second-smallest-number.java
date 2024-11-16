import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int [] arr2 = new int[n];
        // 두번째 작은 수 의 위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }

        Arrays.sort(arr);
        int min = 1;
        int num = 0;
        int idx = 0;

        for (int i = 1 ;i < n ; i++) {
            if (arr[i] == arr[i-1])
                continue;
            min ++;

            if(min == 2) {
                num = arr[i];
                break;
            }

        }

        if (min == 1 )
            System.out.println(-1);
        else {
            for (int i = 0; i < n; i++) {
                if (arr2[i] == num) {
                    idx = i + 1;
                    break;
                }
            }
            System.out.println(idx);
        }


    }
}


