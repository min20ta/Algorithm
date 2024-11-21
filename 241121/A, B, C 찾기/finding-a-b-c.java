
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //2 2 4 7 9 9 11
        //a=2 b+c = 9
        int a = arr[0];
        int b = arr[1];
        int c = arr[5] - b;

        System.out.println(a+" "+b+" "+c);



    }
}



