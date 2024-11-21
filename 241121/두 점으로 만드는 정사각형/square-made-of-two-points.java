
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());


        int x0 = x1 < a1 ? x1 : a1;
        int y0 = y1 < b1 ? y1 : b1;
        int x00 = x2 < a2 ? a2 : x2;
        int y00 = y2 < b2 ? b2 : y2;

        int hori = x00 - x0;
        int ver = y00 - y0;
        int max = Math.max(hori, ver);

        System.out.println(max*max);


    }
}



