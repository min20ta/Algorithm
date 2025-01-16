
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            if (str.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                set.add(k);
            }else if (str.equals("largest")) {
                if(!set.isEmpty())
                    System.out.println(set.last());
                else
                    System.out.println("None");
            }else if (str.equals("smallest")) {
                if(!set.isEmpty())
                    System.out.println(set.first());
                else
                    System.out.println("None");
            } else if (str.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                if (set.contains(k)) {
                    System.out.println(true);
                }else
                    System.out.println(false);
            }else if (str.equals("lower_bound")) {
                int k = Integer.parseInt(st.nextToken());
                if (set.ceiling(k)!=null)
                    System.out.println(set.ceiling(k));
                else
                    System.out.println("None");
            }else if (str.equals("upper_bound")) {
                int k = Integer.parseInt(st.nextToken());
                if (set.higher(k)!=null)
                    System.out.println(set.higher(k));
                else
                    System.out.println("None");
            }else if (str.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                set.remove(k);
            }

        }

       
    }
}