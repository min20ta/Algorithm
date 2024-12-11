
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n =Integer.parseInt(br.readLine());

        String stra = n +"";
        int ten = Integer.parseInt(stra,a);
        int[] arr = new int[20];
        int cnt = 0;

        while (true) {
            if (ten < b){
                arr[cnt] = ten;
                break;
            }
            arr[cnt++] = ten%b;
            ten /= b;

        }

        for (int i = cnt; i >= 0 ; i--) {
            System.out.print(arr[i]);

        }





    }


}


