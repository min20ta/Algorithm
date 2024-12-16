
import java.util.*;
import java.io.*;



public class Main {


    static int [] arr = new int[101];
    static int k = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int answer = -1;

        for (int i = 0; i < m; i++) {
            int money = Integer.parseInt(br.readLine());
            arr[money]++;
            answer = findStudent();
            if (answer != 0) {
                break;
            }

        }
        if (answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);

    }
    static int findStudent() {
        for (int i = 1; i <= 100 ; i++) {
            if (arr[i] >= k) {
                return i;
            }
        }
        return 0;
    }
}
