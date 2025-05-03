
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

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 모든 조합
        // 백트래킹 -> 리스트랑 같이 풀자
        findAll(0);
    }

    static void findAll(int count) {
        if (count == n){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k ; i++) {
            list.add(i);
            findAll(count+1);
            list.remove(list.size()-1);
        }
    }
}


