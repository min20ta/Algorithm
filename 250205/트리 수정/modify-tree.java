
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int d;
    static int ans = Integer.MIN_VALUE;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static int [] findArr;
    static int[][] lineArr;
    static int deleteOne = 0;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static ArrayList<Integer> findList = new ArrayList<>();

    static int minLen = Integer.MAX_VALUE;
    static int subMax = Integer.MIN_VALUE;





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n+1 ; i++) {
            arrayList.add(new ArrayList<>());
        }

        lineArr = new int[n][3];
        for (int i = 0; i < n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());


            arrayList.get(a).add(new pair(b,len));
            arrayList.get(b).add(new pair(a,len));

            lineArr[i][0] = a;
            lineArr[i][1] = b;
            lineArr[i][2] = len;
        }


        //노드자체말고 해당간선만 가지못하도록하자
        for (int i = 0; i < n-1; i++) {
            deleteOne = lineArr[i][0];
            deleteTwo = lineArr[i][1];
            int max = lineArr[i][2];


            getTree(deleteOne);
            max += subMax;

            getTree(deleteTwo);
            max+= subMax;

            ans = Math.max(ans, max);

        }


        System.out.println(ans);

    }

    static void getTree(int deleteNode) {
        subMax = Integer.MIN_VALUE;
        visit = new boolean[n];
        visit[deleteNode] = true;
        tree(deleteNode,0);

    
        visit = new boolean[n];
        visit[findingNode] = true;
        subMax = Integer.MIN_VALUE;
        tree(findingNode,0);
    }

    static void tree(int node,int len) {

        if (subMax < len) {
            subMax = len;
            findingNode = node;
        }
        for (pair next : arrayList.get(node)) {
            if (!visit[next.x] && !((node == deleteOne && next.x == deleteTwo)
                    ||node == deleteTwo && next.x == deleteOne )) {
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










