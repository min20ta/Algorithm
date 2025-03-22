
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[][] copyArr;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int q;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> tempList = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        //1~100 n개 폭탄
        //m 개 이상 연속으로 같은 숫자 폭탄 터짐. 아래로 내려옴

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        //동시에 터져야함
        while (true) {
            int count = 1;
            boolean isBomb = false;
            int size = list.size();
            tempList = new ArrayList<>();

            for (int i = 1; i < size; i++) {
                if (list.get(i) == list.get(i - 1)) {
                    count++;
                    isBomb = true;
                } else {
                    if (count >= m) {
                        count = 1;
                    }else {
                        tempList.add(list.get(i-1));
                    }
                }

            }
            if (list.size() >= 1 && count < m ) {
                tempList.add(list.get(list.size()-1));
            }

            list = new ArrayList<>(tempList);

            if (!isBomb)
                break;
        }

        System.out.println(list.size());
        for (int a : list)
            System.out.println(a);




    }

  static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
  }
}