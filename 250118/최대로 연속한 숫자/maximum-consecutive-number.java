
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
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> removeSet = new TreeSet<>();
        TreeSet<pair> ansSet = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.remove(num);
            removeSet.add(num);

            //하나가 사라지고 2개가 더생김
            int top = n+1;
            int bottom = -1;
            if (set.lower(num) != null) {
                bottom = set.lower(num);
            }
            if (set.higher(num) != null) {
                top = set.higher(num);
            }

            int prev = 0;
            int next = n;
            if (removeSet.lower(num)!= null) {
                prev = removeSet.lower(num)+1;
            }
            if (removeSet.higher(num)!= null) {
                next = removeSet.higher(num)-1;
            }
            //System.out.println("num: "+num+" bottom: "+ bottom+ " top: "+top+" prev:" +prev+ " next: "+next);
            if (i>0)
                ansSet.remove(new pair(next-prev,prev,next));

            ansSet.add(new pair(bottom-prev,prev,bottom));
            ansSet.add(new pair(next-top,top,next));

//            Iterator<pair> iter = ansSet.iterator();
//            while (iter.hasNext())
//                System.out.println(iter.next().length);

            System.out.println(ansSet.first().length+1);





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
                return p.length-this.length;

            }
        }

}