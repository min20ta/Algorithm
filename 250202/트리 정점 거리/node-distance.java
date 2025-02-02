
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static int start ;
    static int end ;
    static int ans ;
    static int root ;
    static boolean [] visit;
    static int [] used;
    static int [] parent;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    static Map<Integer,Integer> map = new HashMap<>();
    static Map<Integer,Integer> goMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            arrayList.add(new ArrayList<>());
        }




        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new pair(b, len));
            arrayList.get(b).add(new pair(a, len));
        }

        for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            visit = new boolean[n+1];
            visit[start] = true;
            tree(start, 0);
            System.out.println(ans);


        }
    }

    static void tree(int node, int len) {
        if (node == end){
            ans = len;
            return;
        }

        for (pair p : arrayList.get(node)) {
            if (!visit[p.x]){
                visit[p.x] =true;
                tree(p.x, len + p.len);
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










