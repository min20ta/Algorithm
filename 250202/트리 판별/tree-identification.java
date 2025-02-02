
import java.util.*;
import java.io.*;


public class Main {

    static int m ;
    static int root ;
    static boolean [] visit;
    static int [] used;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int count;
    static Map<Integer,Integer> map = new HashMap<>();
    static Map<Integer,Integer> goMap = new HashMap<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10001; i++) {
            arrayList.add(new ArrayList<>());
        }


        used = new int[10001];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);


            map.put(a,0);
            map.put(b,map.getOrDefault(b, 0)+1);

            used[a] = 1;
            used[b] = 1;
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

        if (rootCount != 1 || overOneLine) {
            System.out.println(0);
            System.exit(0);
        }
        visit = new boolean[10001];
        visit[root] = true;
        tree(root);

        boolean isOneDistacne = true;
        for (int i = 1; i < 10001; i++) {
            if (used[i]== 1 && !visit[i])
                isOneDistacne = false;
        }
        if (isOneDistacne)
            System.out.println(1);
        else
            System.out.println(0);





    }

    //경로 유일 판단
    static void tree(int node) {



        for(int next : arrayList.get(node)){
            if (!visit[next]) {
                visit[next] = true;
                tree(next);
            }
        }

    }





        }



















