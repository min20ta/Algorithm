
import java.util.*;
import java.io.*;


public class Main {

    static int[] arr;
    static int[] parent;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;
    static boolean haveBomb;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //서로 다른 2개 뽑아 k 경우수
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key,0)+1);
        }

        int sum = 0;
        for (Integer key : map.keySet()) {
            int otherKey = k - key;
            if (map.containsKey(otherKey) && map.get(otherKey) != 0){
                sum += map.get(key) * map.get(otherKey);
                map.put(otherKey, 0);
            }
        }

        System.out.println(sum);



        }
    }






