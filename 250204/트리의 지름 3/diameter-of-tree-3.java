
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int d;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static int [] findArr;
    static int[] distArr;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static ArrayList<Integer> findList = new ArrayList<>();

    static int minLen = Integer.MAX_VALUE;
    static int subMax = Integer.MIN_VALUE;
    static int maxLen = Integer.MIN_VALUE;
    static int maxCount = Integer.MIN_VALUE;




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


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
        visit[1] = true;
        tree(1,0);

        visit = new boolean[n+1];
        visit[findingNode] = true;
        subMax = Integer.MIN_VALUE;
        int start = findingNode;
        tree(findingNode,0);
        int end = findingNode;

        
        int startLen = arrayList.get(start).get(0).len;
        int endLen = arrayList.get(end).get(0).len;
        int small = 0; int big = 0;

        if (startLen < endLen){
            small = start;
            big = end;
        }else {
            small = end;
            big = start;
        }



        visit = new boolean[n+1];
        visit[small] = true;
        visit[big] = true;
        subMax = Integer.MIN_VALUE;
        tree(big,0);


        System.out.println(subMax);



        //지름최대 = 리프노드->리프노드
        //리프노드 전부 고려해야하나
    }

    static void tree(int node,int len) {

        if (subMax < len) {
            subMax = len;
            findingNode = node;
        }

        for (pair next : arrayList.get(node)) {
            if (!visit[next.x]) {
                visit[next.x] = true;
                tree(next.x, len+next.len);
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







}





