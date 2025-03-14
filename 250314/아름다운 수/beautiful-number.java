
import java.util.*;
import java.io.*;


public class Main {

    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[][] parent ;
    static int[][] arr;
    static int[][] copyArr;
    static int ans = 0;
    static boolean [][] visit;
    static int root;
    static int peopleNum;



    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        //1~4 i의 배수씩 나오면 아름다운 수
        // 자리수 조합
        findBeautiful(0);
        System.out.println(ans);
    }

    static void findBeautiful(int idx) {

        if (idx == n){
            if (checkBeautiful())
                ans++;
            return;
        }
        for (int i = 1; i <= 4 ; i++) {
            list.add(i);
            findBeautiful(idx+1);
            list.remove(list.size()-1);
        }
    }

    static boolean checkBeautiful() {
        int prev = list.get(0);
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (prev == list.get(i)) {
                count++;
            }else {
                if (count % prev != 0) {
                    return false;
                }
                prev = list.get(i);
                count = 1;
            }
        }
        if (count % prev != 0)
            return false;
        else
            return true;
    }

}