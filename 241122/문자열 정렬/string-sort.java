
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char [] c = str.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        System.out.println(s);
    }
}



