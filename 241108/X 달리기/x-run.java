import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        //유지, 증가, 감소
        //도착지 1, 최단시간

        int v = 1;
        int distance = 1;
        int min = Integer.MAX_VALUE;
        int time = 0;
        boolean flag = false ;



        for(int t = 1; t <=10000 ; t++) {
            v = 1;
            distance = 1;
            flag = false;
            int j = 1;

           for (j = 2 ; j <= 10000 ; j++) { //초


                if (j >= t) {
                    if(v > 1) {
                        v--;
                        distance += v;
                    }
                    else
                        distance += v;
                } else {
                    v++;
                    distance += v;
                }
                
                if (v == 0)
                    break;

                if (distance == x) {
                    if (v == 1) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag)
                min = Math.min(min, j);

        }

        System.out.println(min);
    }
}