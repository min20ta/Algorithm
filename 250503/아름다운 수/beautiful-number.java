
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int end;
    static int[][] arr;
    static int[][] tempArr;
    static int[] L;
    static int[] R;
    static int ans = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        findBeautiful(0);
        System.out.println(ans);


    }

    static void findBeautiful(int index) {

        if (index == n) {

            if (isBeautiful())
                ans++;

            return;
        }


        for (int i = 1; i <= 4; i++) {
            list.add(i);
            findBeautiful(index+1);
            list.remove(list.size()-1);
        }
    }

    static boolean isBeautiful() {
        // 시작, 끝 구하기
        int prev = list.get(0);
        int count = 1;
        int num = 1 ;

        for (int i = 1; i < n; i++) {
            num = list.get(i);

            if (prev == num) {
                count++;
            }else {
                if (count % prev != 0)
                    return false;

                prev = num;
                count = 1;
            }

        }

        if (count % prev != 0)
            return false;

        return true;

    }
}



