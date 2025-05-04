

import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
//    static int[] dx = {0, 1, -1, 0};
//    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int ans;
    static int [] arr;
    static int[] tempArr;
    static int[] L;
    static int[] R;
    static int size = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tempArr = new int[n];

        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
         }

        do{
            didBomb = false;
            bomb();
        }while (didBomb);

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0){
                ans++;
            }
        }
        System.out.println(ans);

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0){
                System.out.println(arr[i]);
            }
        }

    }


    static void bomb() {
        int first = 0;
        int end = 0;
        int num = 0 ;

        for (int i = 0; i < n; i++) {
           num = arr[i];
           first = i;

            if(num == 0){
                return;
            }

            for (int j = i; j < n ; j++) {
                if (num == arr[j])  {
                    end = j;
                }else
                    break;
            }

            if (end - first + 1 >= m) {
                didBomb = true;
                for (int j = first; j <= end ; j++) {
                    arr[j] = 0;
                }
            }
            i = end;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                tempArr[index++] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = tempArr[i];
        }
    }
}



