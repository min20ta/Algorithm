
import java.util.*;
import java.io.*;


public class Main {

    static int[] arr;
    static int[] temp;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int q;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> tempList = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        //1~100 n개 폭탄
        //m 개 이상 연속으로 같은 숫자 폭탄 터짐. 아래로 내려옴
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] =Integer.parseInt(st.nextToken());
        }

        //동시에 터져야함
        // remove 하는 거는 웬만하면 list쓰지 말자

        int size = n;
        while (true) {
            int count = 1;
            temp = new int[n];
            boolean isBomb = false;

            for (int i = 1; i < size; i++) {
                if (arr[i] == 0) continue;

                if (arr[i] == arr[i-1]) {
                    count++;
                }else  {
                    if (count >= m){
                        for (int j = i-count; j <= i-1 ; j++) {
                            arr[j] = 0;
                            isBomb =true;
                        }
                    }
                    count = 1;
                }
            }

            if (count >= m){
                for (int j = size-count; j <= size-1 ; j++) {
                    arr[j] = 0;
                    isBomb =true;
                }
            }

            if (!isBomb)
                break;

            int index = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i] != 0)
                    temp[index++] = arr[i];
            }
            size = index;
            index = 0;
            for (int i = 0; i < size; i++) {
                arr[index++] = temp[i];
            }

        }

        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (arr[i]!= 0)
                System.out.println(arr[i]);
        }




    }

  static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
  }
}