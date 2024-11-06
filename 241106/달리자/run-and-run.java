import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] aArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int [] bArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        //뒤에서 부터 해서 최소
        for (int i = n-1; i >= 0; i--) {
            int minus = bArr[i] - aArr[i];
            for (int j = minus ; j >= 0 ; j--) {
                
            }
        }


    }
    }