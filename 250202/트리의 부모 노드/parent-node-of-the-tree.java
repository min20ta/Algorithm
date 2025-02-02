
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static boolean [] visit;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n+1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        visit = new boolean[n+1];
        parent = new int[n+1];


        tree(1);


        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }

    static void tree(int node) {

        visit[node] = true;
        for(int next : arrayList.get(node)){
            if (!visit[next]) {
                visit[next] = true;
                parent[next] = node;
                tree(next);
            }
        }

    }



        }







