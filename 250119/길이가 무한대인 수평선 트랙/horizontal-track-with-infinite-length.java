
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        pair [] arr = new pair[n];
        TreeSet<pair> set = new TreeSet<>();

        //만나면 remove
        //분 -> 시간초과ㅠ
        //중복제거,
        //31, 92,103,14
        int ans = 0;



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p2 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int end2 = p2 + v2 * t;
            arr[i] =new pair(p2,v2,end2);
            set.add(new pair(p2,v2,end2));
        }

        Arrays.sort(arr);
        int start = arr[0].person;
        for (int i = 0; i < n-1; i++) {

            if (start > arr[i+1].person){
                set.remove(arr[i+1]);
            }else {
                start = arr[i+1].person;
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