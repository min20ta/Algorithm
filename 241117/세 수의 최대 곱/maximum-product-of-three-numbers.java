import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        boolean isZero = false ;
        int isMinus = 0 ;
        int isPlus = 0 ;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0)
                isZero = true;
            else if (arr[i] > 0)
                isPlus++;
            else
                isMinus++;
        }

        Arrays.sort(arr);

        // 음음양
        // 양양양
        // 0
        //음수밖에 없을때: 작은것들
        int max = Integer.MIN_VALUE;
        if (isMinus >= 2 && isPlus >=1) {
            max = Math.max(max, arr[0]*arr[1]*arr[n-1]);
        }
        if (isPlus >= 3) {
            max = Math.max(max, arr[n-1]*arr[n-2]*arr[n-3]);
        }
        if (isZero)
            max = Math.max(max, 0);
        if (isPlus == 0) {
            max = Math.max(max, arr[n-1]*arr[n-2]*arr[n-3]);
        }

        System.out.println(max);

    }
}


