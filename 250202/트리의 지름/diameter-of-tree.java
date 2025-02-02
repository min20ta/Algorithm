
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static boolean [] visit;
    static ArrayList<ArrayList<pair>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int number;

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
            int len = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(new pair(b,len));
            arrayList.get(b).add(new pair(a,len));

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

        for(pair next : arrayList.get(node)){
            if (!visit[next.x]) {
                visit[next.x] = true;
                tree(next.x, len+next.len);
            }
        }

    }

    static class pair{
        int x;
        int len;

        pair(int x,int len) {
            this.x = x;
            this.len = len;
        }
    }



        }






