
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int t;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;






    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

//        arr = new int[n][m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
        }

        while(t-->0) {
            //소실되는거 먼저 저장
            int temp = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,temp);
        }

        int count = 0;
        for (Integer i : list) {
            System.out.print(i+" ");
            count++;

            if (count == n){
                System.out.println();
                count =0;
            }
        }

    }


    }