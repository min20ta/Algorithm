
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        //m개 하나씩 제거. 연속수열 최장길이
        //arraylist-시간초과 vs treeset-  : remove,
      
        st = new StringTokenizer(br.readLine());
        TreeSet<pair> ansSet = new TreeSet<>(); //빨리 지우려고
        set.add(-1);
        set.add(n+1);
        ansSet.add(new pair(n+1,-1,n+1));

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);

            int z = set.higher(num);  //n+1
            int x = set.lower(num);  //-1

            ansSet.remove(new pair(z-x-1,x,z));
            ansSet.add(new pair(num-x-1,x,num));
            ansSet.add(new pair(z-num-1,num,z));

            System.out.println(ansSet.first().length);
        }





    }
        static public class pair implements Comparable<pair> {
            int length;
            int start;
            int end;

            pair(int length, int start, int end) {
                this.length = length;
                this.start = start;
                this.end = end;
            }
            @Override
            public int compareTo(pair p) { //여기에 없으면 아예 적용이 안되는거라고???
                if (p.length==this.length)
                    return p.start-this.start;
                if (p.start==this.start)
                    return p.end-this.end;
                return p.length-this.length;

            }
        }

}