
import java.util.*;
import java.io.*;


public class Main {

    static int m ;
    static int root ;
    static boolean [] visit;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10001; i++) {
            arrayList.add(new ArrayList<>());
        }


        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);


            map.put(a,0);
            map.put(b,map.getOrDefault(b, 0)+1);

        }
        

        int rootCount = 0;
        boolean overOneLine = false;
        for (Integer i : map.keySet()) {
            if (map.get(i) == 0){
                root =i;
                rootCount++;
            }else if (map.get(i) > 1){
                overOneLine = true;
                break;
            }
        }

//        visit = new boolean[m+1];
//        visit[root] = true;
//        tree(root);

        
        if (rootCount != 1 || overOneLine)
            System.out.println(0);
        else
            System.out.println(1);


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










