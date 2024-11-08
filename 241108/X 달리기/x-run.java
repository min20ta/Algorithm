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
        int time = 1;
        boolean flag = false ;



        while((x-distance-(v+1)) >= (v+1)*(v)/2){
                v++;
                distance += v;
                time++;
        }

      


        while(!(distance ==x && v == 1)){

            if ((x-distance-v) >= (v-1)*(v)/2)
                distance += v;
            else{
                v--;
                distance += v;
            }
            time++;
        }




        System.out.println(time);
    }
}