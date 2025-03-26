
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
    static ArrayList<Integer> list = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //서로 다른 2개 뽑아 k 경우수
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key,0)+1);
            arr[i] = key;
        }

        //3개
        //같은거0개, 1개, 2개
        //2개 골라야 하나
      Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1 ; j < n; j++) {
                int firstKey = arr[i];
                int secondKey = arr[j];
                int thirdKey = k - firstKey - secondKey;

                if (firstKey <= secondKey && secondKey<= thirdKey&&
                        map.containsKey(firstKey) &&
                        map.containsKey(secondKey) &&
                        map.containsKey(thirdKey)) {
                    if (firstKey == secondKey && firstKey == thirdKey) {
                        if (map.get(firstKey) >= 3)
                            sum++;
                    }else if ((firstKey == secondKey && firstKey!= thirdKey) ||
                            (firstKey == thirdKey && firstKey != secondKey)) {
                        if (map.get(firstKey) >= 2)
                            sum++;
                    }else if (secondKey == thirdKey && secondKey!= firstKey){
                        if (map.get(secondKey) >= 2)
                            sum++;
                    }else if (firstKey!= secondKey && secondKey!= thirdKey && firstKey!= thirdKey)
                        sum++;
                  //  System.out.println(firstKey+" "+secondKey+" "+thirdKey+ " "+sum);
                }

            }
        }
        System.out.println(sum);



        }
    }

