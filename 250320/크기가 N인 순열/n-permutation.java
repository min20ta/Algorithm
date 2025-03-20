
import java.util.*;
import java.io.*;


public class Main {

    static int[]arr;
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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        allNum(0);


    }

    static void allNum(int index) {

        if (index == n) {
            for (int a : list)
                System.out.print(a + " ");
            System.out.println();
            return;
        }
        for (int i =1; i <= n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(i);
                allNum(index + 1);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
  static class pair{
        int num;
        int idx;

        pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
  }
}