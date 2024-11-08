import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        //유지, 증가, 감소
        //도착지 1, 최단시간
        //a ->b  . 한번만 순간이동. 최소걷기
        // 3->10. 2-> 8, 9,10
        //1. x까지 걸어간후, x->y, b까지 걸어가기
        // 2. y까지 걸어간후, y->x, b까지 걸어가기
        // 3. a-> b까지 걸어가기


        int min = Integer.MAX_VALUE;
        int timeOne = Math.abs(a-x) + Math.abs(b-y);
        int timeTwo = Math.abs(a-y) + Math.abs(b-x);
        int timeThree = Math.abs(a-b);

        min = Math.min(timeOne, Math.min(timeThree, timeTwo));

        System.out.println(min);




    }
}