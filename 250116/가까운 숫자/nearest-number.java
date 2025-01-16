
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);

            if (set.higher(num)!= null)
                min = Math.min(min, set.higher(num)-num);
            if (set.lower(num)!= null)
                min = Math.min(min, num-set.lower(num));

            System.out.println(min);

        }
      
    }

}