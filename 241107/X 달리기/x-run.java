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



        for(int t = x/2; t <=x ; t++) {
            v = 1;
            distance = 1;
            time = 0;
            flag = false;

            for (int i = 1; i <= x; i++) {
                time++;

                if (i > t) {
                    distance += v--;
                } else {
                    distance += v++;
                }
                if (distance == x) {
                    if (v == 1) {
                        flag = true;
                    }
                }
            }



            if (flag)
                min = Math.min(min, time);

        }

        System.out.println(min);
    }
    }