
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[] ansArr;
    static int[][] copyArr;
    static int ans = 0;
    static boolean[] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> colList = new ArrayList<>();

    static int rowA;
    static int rowB;
    static int colA;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        findAll(0);

    }

    static void findAll(int idx) {
        if (idx == n){
            for (int num : list){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k ; i++) {
            if (list.size() >=2 && list.get(list.size()-1) == list.get(list.size()-2)
                    && (list.get(list.size()-1)) == i)
                continue;
            list.add(i);
            findAll(idx+1);
            list.remove(list.size()-1);
        }
    }
}