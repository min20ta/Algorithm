
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
        int timeA = 1;
        int timeB = 1;

        //매 시간마다 측정
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while(t-- > 0) {
                arrA[timeA] = arrA[timeA - 1] + v;
                timeA++;
            }


        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while(t-- > 0) {
                arrB[timeB] = arrB[timeB - 1] + v;
                timeB++;
            }

        }

        // 동일 시작점, 같은 방향
        // n, m번 걸쳐 v t
        // 매시간마다 선두.
        //답: 전당에 올라간사람 몇번 바뀌었는지

        timeA--;
        timeB--;
        char front = ' ';
        int ans = 0;

        for (int i = 1; i <= Math.min(timeA,timeB); i++) {
            if (arrA[i] > arrB[i])
                front = 'A';
            else if (arrA[i] < arrB[i])
                front = 'B';
            else if(arrA[i] == arrB[i])
                front = 'C';

            if (front == 'A' && arrA[i-1] <= arrB[i-1])
                ans++;
            else if (front == 'B' && arrA[i-1] >= arrB[i-1])
                ans++;
            else if (front == 'C' && (arrA[i-1] < arrB[i-1]|| arrA[i-1] > arrB[i-1]))
                ans++;
        }

        System.out.println(ans);

    }

}
