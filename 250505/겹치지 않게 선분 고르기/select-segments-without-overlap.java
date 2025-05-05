


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int ans;
    static pair [] arr;
    static int[][] tempArr;
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<pair> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i] = new pair(l,r);
        }

        Arrays.sort(arr);
        lines(0);
        System.out.println(max);


    }
    static void lines(int index) {
        if (index == n){
            max = Math.max(max, noMeetLines());
            return;
        }

            list.add(arr[index]);
            lines(index+1);
            list.remove(list.size()-1);
            lines(index+1);

    }

    static int noMeetLines() {
        //LR tech ?


        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;

            for (int j = i+1; j < list.size() ; j++) {
                int nx = list.get(j).x;
                int ny = list.get(j).y;

                if ((x <= nx && nx <= y)
                        || (x <= ny && ny <= y)) { //겹침
                    return 0;

                }
            }
        }

        return list.size();

    }

    static class pair implements Comparable<pair>{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair p) {
            if (p.x == this.x)
                return p.y - this.y;
            return p.x - this.x;
        }
    }

}



