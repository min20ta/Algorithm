
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int start;
    static int end;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = start; i <= end ; i++) {
            sum += checkBeauty(i);
        }
        System.out.println(sum);

        // x~y . 한개만 다른수

    }
    static int checkBeauty(int num) {
        String str = String.valueOf(num);
        char [] c = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i],0)+1);
        }

        if (map.size() != 2) return 0;
        else {
            for (int val : map.values()) {
                if (val == 1){
                    return 1;
                }
            }
            return 0;
        }

    }

}

