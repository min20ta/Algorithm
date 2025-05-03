
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int end;
    static int[][] arr;
    static int[][] tempArr;
    static int[] L;
    static int[] R;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        String a = br.readLine();

        //a요일 몇번 등장
        int [] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int first = d1; int second = d2;

        for (int i = 0; i < 12; i++) {
            if (i == m1-1)
                break;
            else
                first += month[i];
        }

        for (int i = 0; i < 12; i++) {
            if (i == m2-1)
                break;
            else
                second += month[i];
        }

        int diff = second - first;
        int day = diff % 7;
        int count = diff / 7;
        String [] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        for (int i = 0; i < 7; i++) {
            if (a.equals(days[i])){
                if (day >= i)
                    count++;
            }
        }

        System.out.println(count);


    }
}



