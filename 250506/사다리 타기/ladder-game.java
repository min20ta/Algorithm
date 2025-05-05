


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
    static boolean[][] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [] ansArr;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<pair> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new pair[m];
        ansArr = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new pair(a,b);
        }

        Arrays.sort(arr);
        getAnsLadder();
        findLadder(0);


        System.out.println(min);


    }
    static void findLadder(int index) {
        if (index == m){
            min = Math.min(min, getLadderNum());
            return;
        }

        list.add(arr[index]);
        findLadder(index+1);
        list.remove(list.size()-1);
        findLadder(index+1);
    }

    static int getLadderNum() {

        int [] tempArr = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            tempArr[i] = i;
        }

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i).x;
            int next = start+1;

            int temp = tempArr[start];
            tempArr[start] = tempArr[next];
            tempArr[next] = temp;

        }
        
        for (int i = 1; i <= n; i++) {
            if (tempArr[i] != ansArr[i]) {
                return Integer.MAX_VALUE;
            }
        }

        return list.size();
    }

    static void getAnsLadder() {

        for (int i = 1; i <= n ; i++) {
            ansArr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int start = arr[i].x;
            int next = start + 1;

            int temp = ansArr[start];
            ansArr[start] = ansArr[next];
            ansArr[next] = temp;
        }

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
            if (p.y == this.y)
                return this.x - p.x;
            return this.y - p.y;
        }
    }

}



