import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int k;
    static int b;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int [] arr= new int[b+1];
        int []save = new int[n+1];

        //st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= b; i++) {
                arr[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //1~n 인데 b들 없다.
        //본인이 살았을때 경우
        //누적합 경우
        int zero = 0;
        int zeroIdx = 1;
        for (int i = 1; i <= n ; i++) {

            if (arr[zeroIdx] <= i) {
                zero = arr[zeroIdx];
                zeroIdx++;
            }
            save[i] = i - zero;
        }

       //추가시
        //이어붙이기
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k +1; i++) {
            int count = 0;
            for (int j = i; j <= i+k-1; j++) {
                if (save[j] == 0){
                    count++;
                }
            }
            min = Math.min(min,count);

            }
        System.out.println(min);
        }


        

        





        }







