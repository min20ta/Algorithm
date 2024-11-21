
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //3 3 4 6 7 7 7 10 10 10 11 13 14 14 17
        int a = arr[0];
        int b = arr[1];
        int abcd = arr[14];
        int cd = abcd - a-b;
        int ab = a + b;

        int c = 0;
        int d = 0;
        int idx = 0;

        for (int i = 0; i < 15; i++) {
            if (cd==arr[i]) {
                idx = i;
                break;
            }

        }

        for (int i = 2; i < 15; i++) {
            for (int j = i+1; j <15 ; j++) {
                if (arr[i]+arr[j] == cd) {
                    c = arr[i];
                    d = arr[j];
                    break;
                }
            }
        }

        System.out.println(a+" "+b+" "+c+" "+d);



    }
}



