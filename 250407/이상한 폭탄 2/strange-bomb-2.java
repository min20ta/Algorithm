
import java.util.*;
import java.io.*;


public class Main {

    static int[] arr ;
    static int[][] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0,-1,-1,1,1};
    static int[] dy = {-1, 0,0, 1,-1,1,1,-1};
    static int n;
    static int m;
    static int k;
    static int x;
    static int y;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //같은 번호 부여 폭탄거리k 폭발
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> bombList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                if (arr[i] == arr[j]) {
                    if (j-i <= k) {
                        bombList.add(arr[i]);
                    }
                }
            }
        }

        if (bombList.isEmpty())
            System.out.println(-1);
        else  {
            Collections.sort(bombList, Collections.reverseOrder());
            System.out.println(bombList.get(0));
        }
    }

}


