
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int ans = Integer.MIN_VALUE;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static boolean [] finish;
    static int[][] lineArr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int subMax = Integer.MIN_VALUE;
    static Set<Integer>set = new HashSet<>();





    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n+1 ; i++) {
            arrayList.add(new ArrayList<>());
        }

        int checkNode = 0;
        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);

            set.add(a); set.add(b);

            checkNode = a;
        }


        finish = new boolean[n+1];
        visit = new boolean[n+1];
        visit[checkNode] = true;
         boolean first = edge();
         boolean second =  place(checkNode);

         ans = n- set.size();
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(cycle);
        //그래프가 여러개일수있음
         if (first && second && !cycle){
             ans = 1 + n-set.size();
         }



        System.out.println(ans);

    }




    static boolean edge() {
        if (set.size() -1 == m)
            return true;
        return false;
    }


    static boolean place(int node) {

          tree(node, -1);

          boolean flag = true;

          for (Integer i : set) {
              if (!visit[i]){
                  flag = false;
                  break;
              }
          }

          if (flag)
              return true;
          else
              return false;
    }

    static void tree(int node, int parent) {
        for (Integer next : arrayList.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                tree(next, node);
            }else if (next != parent)
                cycle = true;
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




