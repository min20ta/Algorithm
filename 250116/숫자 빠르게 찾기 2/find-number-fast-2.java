
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            if(set.ceiling(num)!= null){
                System.out.println(set.ceiling(num));
            }else
                System.out.println(-1);
        }

    }
}