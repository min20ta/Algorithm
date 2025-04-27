
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


        //짝홀, 최대
        int even = 0;
        int odd = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num%2 == 0)
                even++;
            else
                odd++;
        }

        boolean evenTime = true;
        int bundle = 0;
        int makeEven = even;
        int makeOdd = odd;

        while (makeEven > 0 || makeOdd > 0) {


            if (evenTime) { //짝수
                evenTime = false;

                if (makeEven > 0) {
                    makeEven--;
                    bundle++;
                }
                else if (makeOdd >= 2) {
                    makeOdd -= 2;
                    bundle++;
                }else {
                    bundle--;
                    break;
                }

            }else  {  //홀수
                evenTime = true;
                if (makeOdd > 0){
                    makeOdd--;
                    bundle++;
                }else {
                    bundle--;
                    break;
                }

            }


        }

        System.out.println(bundle);




    }



}



