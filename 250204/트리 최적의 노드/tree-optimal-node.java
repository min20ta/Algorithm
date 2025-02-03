
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
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int subMax = Integer.MIN_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n+1 ; i++) {
            arrayList.add(new ArrayList<>());
        }

        //각 노드별 전부탐색해서 가장 먼 거리찾음
        // 최소인 노드

        for (int i = 0; i < n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            visit[i] = true;
            subMax = Integer.MIN_VALUE;
            tree(i, 0);
            min = Math.min(min, subMax);
        }

        System.out.println(min);

    }

    static void tree(int node, int value) {

        if (subMax < value) {
            subMax = value;
        }

        for (Integer next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                tree(next, value + 1);
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










