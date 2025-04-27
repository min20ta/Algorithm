
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static char [] arr;
    static int [] y;
    static int [] L;
    static int [] R;


    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int velocity = 1;
        int distance = n;
        
        while (true) {
            distance -= velocity;
            time++;
            
            if (distance == 0)
                break;
            
            if (distance >= (velocity+1)*(velocity+2)/2)
                velocity++;
            else if (distance >= velocity*(velocity+1)/2);
            else 
                velocity--;
        }
        System.out.println(time);


    }



}



