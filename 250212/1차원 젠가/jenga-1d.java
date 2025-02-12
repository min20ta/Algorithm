
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());

//       arr = new int[n][m];
        LinkedList<Integer> list = new LinkedList<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken())-1;
        int e1 = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken())-1;
        int e2 = Integer.parseInt(st.nextToken())-1;


        for (int i = s1; i <=e1 ; i++) {
            list.set(i,0);
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i)!=0)
                list2.add(list.get(i));
        }

//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i));
//        }
        for (int i = s2; i <=e2 ; i++) {
            list2.set(i,0);
        }

        list.clear();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i)!=0)
                list.add(list2.get(i));
        }

        System.out.println(list.size());
        for(Integer i : list)
            System.out.println(i);





    }

    static class pair{
        int x;
        int y;
        int len;


        pair(int x, int y , int len)
        {
           this.x = x;
           this.y = y;
           this.len = len;
        }
    }


    }