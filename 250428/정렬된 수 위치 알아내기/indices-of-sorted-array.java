
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int q;
    static int end;
    static pair [] arr;
    static pair [] arr2;
    static int [] y;
    static int [] L;
    static int [] R;


    static double max = Double.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new pair[n];
        arr2 = new pair[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = i;
            arr[i] = new pair(num, index);
            arr2[i] = arr[i];
        }

        Arrays.sort(arr, new Comparator<pair>() {
            @Override
            public int compare(pair p1, pair p2) {
                if (p1.num == p2.num)
                    return p1.index - p2.index;
                return p1.num - p2.num;
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i].num == arr[j].num
                        && arr2[i].index == arr[j].index) {
                    System.out.print(j+1+" ");
                }
            }
        }


    }

    static class pair {
        int num;
        int index;

        pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }


}



