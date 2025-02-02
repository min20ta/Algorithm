
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int sum = 0;
    static int root;
    static boolean[] visit;
    static boolean ans;
    static int[] used;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> goMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + 1; i++) {
            arrayList.add(new ArrayList<>());
        }


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        visit = new boolean[n+1];
        visit[1] = true;
        tree(1,0);

        if (sum %2 ==0)
            System.out.println(0);
        else
            System.out.println(1);




    }





    static void tree(int node, int len) {

        boolean isLeaf = true;

        for (Integer i  : arrayList.get(node)) {
            if (!visit[i]){
                visit[i] =true;
                isLeaf = false;
                tree(i,len+1 );
            }
        }

        if (isLeaf)
            sum+=len;

    }




    static class pair {
        int x;

        pair(int x) {
            this.x = x;
        }
    }

        }


