
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char [] c1 = str1.toCharArray();
        char [] c2 = str2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        boolean flag  = true;

        if (c1.length != c2.length)
            flag = false;
        else {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    flag = false;
                    break;

                }
            }
        }
        if (flag)
            System.out.println("Yes");
        else
            System.out.println("No");




    }
}



