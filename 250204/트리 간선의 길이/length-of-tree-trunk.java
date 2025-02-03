
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int k;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static ArrayList<Integer>[] tree;
    static int[] arr;
    static int[] parentArr;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int subMax = Integer.MIN_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n+1 ; i++) {
            arrayList.add(new ArrayList<>());
        }


        for (int i = 0; i < n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new pair(b, value));
            arrayList.get(b).add(new pair(a, value));
        }

        visit = new boolean[n+1];
        visit[1] = true;
        tree(1, 0);

        
        visit = new boolean[n+1];
        visit[findingNode] = true;
        tree(findingNode,0);

        System.out.println(subMax);

    }

    static void tree(int node, int value) {

        if (subMax < value) {
            subMax = value;
            findingNode = node;

        }

        for (pair p : arrayList.get(node)) {
            if (!visit[p.x]) {
                visit[p.x] = true;
                tree(p.x, value + p.value);
            }
        }
    }

    static class pair {
        int x;
        int value;

        pair(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }




        }










