import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int [][] arr;
    static int [][] dp;

    static int [] a;
    static int [] b;
    static ArrayList<Integer> list = new ArrayList<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int count = 0;
        for (int i = 0; i <= n-m; i++) {
            if (findBeautiful(i)) {
                count++;
            }
        }

        System.out.println(count);


    }

    //똑같은거 처리
    static boolean findBeautiful(int x) {
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = x; i <x +m ; i++) {
            list2.add(a[i]);
        }
        Collections.sort(list2);
        for (int i = 0; i < m; i++) {
            if (list.get(i) != list2.get(i))
                return false;
        }

        return true;
    }




    }



















