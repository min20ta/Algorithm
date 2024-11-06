import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] aArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int [] bArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        //뒤에서 부터 해서 최소
        for (int i = 0; i < n; i++) {
            if (aArr[i] > bArr[i])  {
                int num = aArr[i] - bArr[i];
                aArr[i] -= num;
                aArr[i+1] += num;
                answer += num;
            }
        }
        System.out.println(answer);

    }
}