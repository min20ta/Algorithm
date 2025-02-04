
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int d;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int findLen;
    static int [] findArr;
    static int[] arr;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static ArrayList<Integer> findList = new ArrayList<>();

    static int minLen = Integer.MAX_VALUE;
    static int subMax = Integer.MIN_VALUE;
    static int maxLen = Integer.MIN_VALUE;
    static int maxCount = Integer.MIN_VALUE;
    static treeSort maxT = new treeSort(0,0);



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n+1 ; i++) {
            arrayList.add(new ArrayList<>());
        }
        //최대한 많은 간선. 간선길이가 아님
        // 최소한날짜(길이가 짧아야함). =전체길이/d

        //간선개수,길이
        //각 리프노드로 부터 전부 돌려야하나?

        for (int i = 0; i < n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());


            arrayList.get(a).add(new pair(b,len));
            arrayList.get(b).add(new pair(a,len));
        }

        visit = new boolean[n+1];
        findArr = new int[n+1];
        visit[1] = true;
        tree(1,0,0);


        for (Integer i : findList) {
                visit = new boolean[n+1];
                visit[i] =true;

                tree2(i,0,0);


        }

        ans = maxT.distance/d;
        if (maxT.distance % d != 0)
            ans++;
        System.out.println(ans);

    }

    static void tree(int node, int count, int len) {

        if (subMax < count) {
            subMax = count;
            findList.clear();
            findList.add(node);
        } else if (subMax == count) {
            findList.add(node);
        }

        for (pair next : arrayList.get(node)) {
            if (!visit[next.x]) {
                visit[next.x] = true;
                tree(next.x, count+1, len+next.len);
            }
        }
    }

    static void tree2(int node,int count, int len) {


        for (pair next : arrayList.get(node)) {
            if (!visit[next.x]) {
                visit[next.x] = true;
                treeSort t = new treeSort(count+1, len+next.len);
                if(t.isGreaterThan(maxT)) {
                    maxT = t;
                    
                }

                tree2(next.x,count+1, len+next.len);
            }
        }
    }

    static class pair {
        int x;
        int len;

        pair(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }

    static class treeSort {
        int count;
        int distance;

        treeSort(int count,int distance) {
            this.count = count;
            this.distance = distance;
        }

        public boolean isGreaterThan(treeSort t) {
            if (this.count == t.count)
                return this.distance <= t.distance;
            return t.count < this.count;
        }
    }




}













