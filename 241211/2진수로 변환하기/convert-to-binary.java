
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int [] digits = new int[20];
        int index = 0;

        while (true) {
                if (num< 2) {
                    digits[index] = num;
                    break;
                }
               digits[index++] = num%2;
               num/=2;
        }

    for (int k = index ; k >= 0 ; k--) {
        System.out.print(digits[k]);
    }


    }
}
