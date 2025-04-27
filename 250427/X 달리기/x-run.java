
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
        int distance = 0;

        for (int i = 2; i <= 10 ; i++) { // 감소하는 위치
             velocity = 1;
             distance = 1;

            for (int j = 2; j <= 10 ; j++) {

                if (j >= i){
                    if (velocity != 1)
                        velocity--;
                }else {
                    velocity++;
                }

                distance += velocity;
             //  System.out.println(i+" "+ distance);

                if (distance == n && velocity == 1){
                    min = Math.min(min,j);
                    break;
                }
            }
            
        }
        System.out.println(min);


    }



}
