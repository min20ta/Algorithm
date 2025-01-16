
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        TreeSet<pair> set = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new pair(l,p));
        }

        int m= Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("rc")) {
                int level = Integer.parseInt(st.nextToken());
                if (!set.isEmpty()){
                if (level == 1) {
                    System.out.println(set.first().p);
                }else if (level == -1) {
                    System.out.println(set.last().p);
                }
                }
            }else if (str.equals("ad")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                set.add(new pair(l,p));

            } else if (str.equals("sv")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                set.remove(new pair(l,p));
            }

        }
    }

    static class pair implements Comparable<pair> {
        int l ;
        int p;

        pair(int l, int p) {
            this.l = l;
            this.p = p;
        }

        @Override
        public int compareTo(pair pa) {
            if (pa.l == this.l)
                return pa.p - this.p;
            return pa.l - this.l;
        }
    }
}