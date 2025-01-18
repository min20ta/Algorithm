
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
 
        TreeSet<Long> set = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            long end = (long) (start + v * t);
            
            //앞선사람 모두 제거
            while(true) {
                if (set.higher(end) == null)
                    break;
                long next = set.higher(end);
                set.remove(next);
            }
            
            set.add(end);
         
        }
        System.out.println(set.size());
    }      

}