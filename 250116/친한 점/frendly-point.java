
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        TreeSet<pair> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new pair(x,y));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (set.ceiling(new pair(x,y))!= null){
                pair p = set.ceiling(new pair(x,y));
                System.out.println(p.x+" "+p.y);
                }
            else
                System.out.println(-1+" "+-1);
        }

    }

    static class pair implements Comparable<pair> {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p){
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;
        }
    }
}