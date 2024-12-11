
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String n =br.readLine();

        int num = Integer.parseInt(n,2);
        num = num*17;

        System.out.println(Integer.toBinaryString(num));




    }


}

