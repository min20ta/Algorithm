
import java.util.*;
import java.io.*;


public class Main {

    static pair[]arr;
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
    static List<pair> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new pair[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new pair(Integer.parseInt(st.nextToken()),i);
        }
        //최소점프. -1
        findMin(0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);

    }
    static void findMin(int idx) {
        //정해진거 없이 ox, 가능한지 검사
        if (idx == n) {
            if (isPossible()) {
                min = Math.min(min, list.size() - 1);
            }
            return;
        }
       list.add(arr[idx]);
       findMin(idx+1);

       list.remove(list.get(list.size()-1));
       findMin(idx+1);
    }

  static boolean isPossible() {


    if (list.isEmpty())
        return false;

    if (list.get(0).idx != 0)
        return false;

    if(list.get(list.size()-1).idx != n-1)
        return false;

      pair p = list.get(0);
      int cur = p.idx;
      int maxJump = p.num;
      for (int i = 1; i < list.size(); i++) {
          int next = list.get(i).idx;
          if (next - cur > maxJump)
              return false;

          cur = next;
          maxJump = list.get(i).num;
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