import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [] arr = new char[n];
        int [] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = st.nextToken().charAt(0);
            arr2[i] = (int)arr[i];
        }


        //n명 알파벳순
        //인접한 두사람 위치를 바꾸는것만
        //최소

        //a d b c
        // a b d c
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr2[i] < arr2[i-1]) {
                int temp = arr2[i-1];
                arr2[i-1] = arr2[i];
                arr2[i] = temp;
                count++;
            }
        }

        System.out.println(count);



    }
    }


