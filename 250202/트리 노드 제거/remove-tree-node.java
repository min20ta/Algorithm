
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int root ;
    static boolean [] visit;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n+1; i++) {
            arrayList.add(new ArrayList<>());
        }

        parent = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                root = i;
                continue;
            }

            parent[i] = num;
            arrayList.get(i).add(num);
            arrayList.get(num).add(i);
        }

        int erase = Integer.parseInt(br.readLine());

          if (erase == root) {
            System.out.println(0);
            return;
        }

        arrayList.get(erase).clear();
        arrayList.get(parent[erase]).remove(Integer.valueOf(erase));

        visit = new boolean[n+1];
        visit[root] = true;
        tree(root);


        System.out.println(count);


    }

    //리프노드인거 어떻게 판별하지
    static void tree(int node) {

        boolean isLeaf = true;

        for(int next : arrayList.get(node)){
            if (!visit[next]) {
                visit[next] = true;
                isLeaf = false;
                tree(next);
            }
        }

        if (isLeaf)
            count++;

    }





        }










