
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;

    static pair [] arr;
    static ArrayList<pair> arrayList = new ArrayList<>();
    static ArrayList<pair> mList = new ArrayList<>();
    static double min = Double.MAX_VALUE;
    static int dist = 0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new pair(x,y);
        }

        //가장 먼 두점 거리 최소

        findMax(0,0);
        System.out.println(Math.round(Math.pow(min,2)));
    }


    static void findMax(int depth, int start) {
        if (depth == m) {
                double value = calcFirst();
                min = Math.min(min, value);
            return;
        }

        for (int i = start; i < n; i++) {
            arrayList.add(arr[i]);
            findMax(depth+1, i+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    static double calcFirst() {
        double maxVal = Double.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                pair p1 =arrayList.get(i);
                pair p2 =arrayList.get(j);

                maxVal = Math.max(maxVal,dist(p1.x, p1.y, p2.x, p2.y));
            }
        }

        return maxVal;
    }

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
        }









