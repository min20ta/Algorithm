
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
    static List<Integer> list = new ArrayList<>();
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }


        int count = 0;

        while (!checkEnd()){
            int num = list.get(0);
            int location = 0;
            min = Integer.MAX_VALUE;

            for (int j = 2; j < n ; j++) {
                int diff = Math.abs(num - list.get(j));
                if (min >= diff){
                    location = j;
                    min = diff;
                }
            }

            if (list.get(location) < num) {
                list.add(location+1,num);
            }else {
                list.add(location,num);
            }
            list.remove(0);

            count++;
        }

        System.out.println(count);


    }


    static boolean checkEnd() {
        for (int i = 0; i < n; i++) {
            if (list.get(i) != i+1)
                return false;
        }

        return true;
    }

}



