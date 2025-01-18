
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        TreeSet<pair> set = new TreeSet<>();

        //만나면 remove
        //분 -> 시간초과ㅠ
        //중복제거,
        //31, 92,103,14
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int end = p + v * t;
        set.add(new pair(p, v, end));
        ans++;


        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p2 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int end2 = p2 + v2 * t;
            //System.out.println(set.last().end+" "+ end2);
            if (set.last().end < end2) {
                set.add(new pair(p2, v2, end2));
            } else if (set.last().end > end2) {
                set.remove(set.last());
                set.add(new pair(p2,v2,end2));
            }


        }
        System.out.println(set.size());
    }

        static class pair implements Comparable<pair> {
        int person;
        int velocity;
        int end;

        pair(int person, int velocity,int end) {
            this.person = person;
            this.velocity = velocity;
            this.end = end;
        }

        @Override
            public int compareTo(pair p) {

            return this.end - p.end;
        }
        }

}