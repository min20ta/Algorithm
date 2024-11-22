
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str);

        for (String s: str){
            System.out.println(s);
        }
    }
}



