
import java.util.*;
import java.io.*;



public class Main {


 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arrA = new int[1000001];
        int [] arrB = new int[1000001];
        int timeA = 0;
        int timeB = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int level = t;
            int k =1;
            while(level-- > 0) {
                arrA[timeA++] = v*t*(k++)/t;
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int level = t;
            int k =1;
            while(level-- > 0) {
                arrB[timeB++] = v*t*(k++)/t;
            }
        }


        char where = ' ';
        int count = 0;
        for (int i = 0; i < 1000001; i++) {

            if (i == 0){
                if (arrA[i] > arrB[i]) {
                    where = 'A';

                } else if (arrA[i] < arrB[i]) {
                    where = 'B';

                }
            } else if (arrA[i] > arrB[i])  {
                    if (where == 'B') {
                        count++;
                    }
                    where = 'A';

            } else if (arrA[i] < arrB[i])  {
                if (where == 'A') {
                    count++;
                }
                where = 'B';
            }
        }

        System.out.println(count);


    }
     
}
