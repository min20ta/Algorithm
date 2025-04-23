
import java.util.*;
import java.io.*;


public class Main {


    static int[] arr;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int b;
    static int end;
    static int [] p;
    static int [] s;


    static int max = Integer.MIN_VALUE;
    static int hmax = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }


        for (int h = 1; h <= max ; h++) {
            hmax = Math.max(hmax,findGroup(h));
        }

        System.out.println(hmax);

        //높이-> 빙상최대(물에 잠기지 않은 것 한덩이)
    }

    //제일 처음 해당안될때 prev 문제가 됨
    static int findGroup(int h) {
        int prev = 0;
        int count = 0;

        if (arr[0] > h)
            count = 1;

        for (int i = 1; i < n; i++) {
            count++;

            if (arr[i] <= h)
                count--;
            else if (arr[i] > h && arr[i-1] >h){
                prev = i;
                count--;
            }else if (arr[i] > h){
                prev = i;

            }
        }
        return count;
    }

}



