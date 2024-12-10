
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int [] last = {31,28,31,30,31,30,31,31,30,31,30,31};
        int time1= 0 ;
        int month = 1;
        for (int i = 0; i < 12; i++) {
            if (month == m1)
                break;;
            month++;
            time1+= last[i];
        }
        time1 += d1;

        int time2 = 0;
       month = 1;
        for (int i = 0; i < 12; i++) {
            if (month == m2)
                break;;
            month++;
            time2+= last[i];
        }
        time2 += d2;



        System.out.println(time2-time1+1);

    }
}



