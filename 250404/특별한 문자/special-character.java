
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int t;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //r가장 먼저
        List<Character> list = new ArrayList<>();
        for (char key : map.keySet()) {
            if (map.get(key) == 1)
                list.add(key);
        }

        if (list.isEmpty()) {
            System.out.println("None");
            System.exit(0);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (list.contains(c)){
                System.out.println(c);
                System.exit(0);
            }
        }

    }
}


