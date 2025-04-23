
import java.util.*;
import java.io.*;


public class Main {


    static int[] aArr;
    static int[] bArr;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int b;
    static int end;
    static int [] p;
    static int [] s;


    static int max = Integer.MIN_VALUE;
    static int hmax = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        aArr = new int[n];
        bArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,aArr[i]);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        // 1~n까지 집
        //ai 명씩
        // 현재집, 오른쪽(더큼) -> bi명
        //답: 이동합 최소
        int diff = 0;
        int ans = 0;
        for (int i = 0; i < n-1 ; i++) {
            if (aArr[i] > bArr[i]){
                diff = aArr[i] - bArr[i];
                aArr[i+1] += diff;
                ans += diff;
            }
        }
        System.out.println(ans);

    }

}



