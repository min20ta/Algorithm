
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static boolean [] visit;
    static int [] parent;
    static int [][] lenArr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int number;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n+1; i++) {
            arrayList.add(new ArrayList<>());
        }

        lenArr = new int [n+1][n+1];
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);

            lenArr[a][b] = len;
            lenArr[b][a] = len;
        }

        visit = new boolean[n+1];


        visit[1] = true;
        tree(1, 0);


        visit = new boolean[n+1];
        max = Integer.MIN_VALUE;
        visit[number] = true;
        tree(number, 0);


            System.out.println(max);


    }

    static void tree(int node, int len) {
        if (max < len){
            max = len;
            number = node;
            
        }

        for(int next : arrayList.get(node)){
            if (!visit[next]) {
                visit[next] = true;
                tree(next, len+lenArr[node][next]);
            }
        }

    }



        }





