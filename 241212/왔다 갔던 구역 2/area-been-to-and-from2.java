
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[2001];
        int start = 1000;

        for (int i = 0; i < n; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if (d == 'R'){
                for (int j = start; j < start+x ; j++) {
                    arr[j]++;

                }
                start = start+x;
            }else {
                for (int j = start -x; j < start ; j++) {
                    arr[j]++;
                }
                start = start-x;
            }

        }

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i <= 2000; i++) {
            if (arr[i] >= 2)
                count++;
        }

        System.out.println(count);


    }


}





