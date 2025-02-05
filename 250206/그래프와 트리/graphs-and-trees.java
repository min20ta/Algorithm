
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int edgeCount = 0;
    static int nodeCount = 0;
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


        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);

            set.add(a); set.add(b);


        }



        visit = new boolean[n+1];

        for (int i = 1 ; i <= n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                nodeCount = 0;
                edgeCount = 0;
                cycle = false;

                place(i);

                if (!cycle && edgeCount/2 == nodeCount -1)
                    ans++;
            }
        }


        System.out.println(ans);

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
        nodeCount++;

        for (Integer next : arrayList.get(node)) {
            edgeCount++;
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




