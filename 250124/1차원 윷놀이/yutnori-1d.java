
import java.util.*;
import java.io.*;


public class Main {

    static int m ;
    static int n ;
    static int k ;
    static int [] arr;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        findMax(0);
        System.out.println(max);
        }


        static void findMax(int count) {
        if (count == n){
            max = Math.max(max, calc());
            return;
        }

            for (int i = 1; i <= k  ; i++) {
                arrayList.add(i);
                findMax(count+1);
                arrayList.remove(arrayList.size()-1);
            }


    }

    static int calc() {
        int sum = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int queen = arrayList.get(i);
            int distance = arr[i];
            map.put(queen, map.getOrDefault(queen,1)+distance);
        }

        for (int stop : map.keySet()) {
            if (map.get(stop) >= m) {
                sum++;
            }
        }
        return sum;
    }
    }




