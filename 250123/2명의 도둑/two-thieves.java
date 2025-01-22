
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static int m;
    static int c;
    static int [][] arr;
  
    static int [] a = new int[5];
    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {

                        if (possible(i,j,k,l)){ //행, 열 고름
                            max = Math.max(max, findMax(i,j)+findMax(k,l));

                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

   static boolean possible(int sx1, int sy1, int sx2, int sy2) {
        //격자 위치 안에 있어야함
       if (sy1+m-1 >= n || sy2 + m-1 >= n)
           return false;

       //다른행일때
       if (sx1 != sx2)
           return true;

       //같은행일때 열 겹친다면 안됨
       if (!(sy1 + m-1 < sy2 || sy2 + m-1 < sy1))
           return false;

       //행이 같아도 열이 겹치지 않는 다면 가능
       return true;
   }

   static int findMax(int sx, int sy) {
        //c를 넘지 않는 최대 가치
       for (int i = sy; i <= sy + m - 1 ; i++) {
           a[i-sy] = arr[sx][i];
       }

       maxVal = 0;
       findMaxSum(0,0,0);

       return maxVal;
   }


   static void findMaxSum(int idx, int weight, int value) {
        if(idx == m) {
            if (weight<= c)
                maxVal = Math.max(maxVal,value);
            return;
       }

        findMaxSum(idx+1, weight,value);
        findMaxSum(idx+1, weight+a[idx], value+a[idx]*a[idx]);
   }
}



