
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

        findFirst(0);

    }

    static void findFirst(int idx) {

        if (idx == n){
            if (isPossible()){
                for (int a : list)
                    System.out.print(a);
                System.exit(0);
            }
            return;
        }

        for (int i = 4; i <= 6 ; i++) {
              list.add(i);
              findFirst(idx+1);
              list.remove(list.size()-1);
        }
    }

    static boolean isPossible() {

        //인접한수열
        //수열길이 : n/2까지
        //모두 통과해야 true
        for (int len = 1; len <= n/2 ; len++) {
            for (int i = 0; i < n; i++) {// 처음시작위치
                if (isSameList(i, len))
                    return false;
            }
        }
        return true;
    }

    static boolean isSameList(int x, int len) {
        int start = x;
        int end = x + len-1;

        int start2 = x+ len;
        int end2 = start2 + len-1;

        if (!(end < n && start2 < n && end2 < n))
            return false;

        for (int i = 0; i < len ; i++) {
           if (list.get(start+i) != list.get(start2+i))
               return false;
        }

        return true;
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