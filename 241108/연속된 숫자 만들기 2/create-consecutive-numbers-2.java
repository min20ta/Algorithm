import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int [] arr = new int[3];
        for(int i = 0 ; i < 3 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // abc 양끝만 선택해서 남은 두사람사이로. 연속된 숫자. 최소횟수
        //위치가 주어짐
        // 1. a-b b-c == 1 답 : 0
        // 2. a선택 -> . bc 차이가 2일때 : 1, 3이상때 : b b+2 c, -> 2
        // 3. c 선택 ->  ab차이가 2일때 : 1,
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        int ans = 0;


        if (b-a == c-b && b-a == 1)
            ans = 0;
        else if (c-b == 2)
            ans = 1;
        else if (b-a == 2)
            ans = 1;
        else if (c-b >= 3)
            ans = 2;
        else
            ans = 2;


        System.out.println(ans);
    }