import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //첫번째가 이기는 최대값
        // 1= 주먹, 2= 가위 3= 보

        // 1= 주먹 , 2= 보 3= 가위
        // 1 = 가위 2= 보 1= 주먹
        // 1= 가위 2= 주먹 3= 보
        // 1= 보 2= 주먹 3= 가위
        // 1 = 보 2= 가위 3= 주먹
        int oneSum = 0;
        int twoSum = 0;
        int threeSum = 0;
        int fourSum = 0;
        int fiveSum = 0;
        int sixSum = 0;

        for (int i = 0 ; i < n ; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            oneSum += one(a,b);
            twoSum += two(a,b);
            threeSum += three(a,b);
            fourSum += four(a,b);
            fiveSum += five(a,b);
            sixSum += six(a,b);
        }

        int [] ans = new int[6];
        ans[0] = oneSum;
        ans[1] = twoSum;
        ans[2] = threeSum;
        ans[3] = fourSum;
        ans[4] = fiveSum;
        ans[5] = sixSum;

        Arrays.sort(ans);

        System.out.println(ans[5]);




    }

    // 1= 주먹, 2= 가위 3= 보
    static int one (int me, int you) {
        if(me==1 && you==2)
            return 1;
        else if (me == 1 && you == 3)
            return 0;
        else if (me == 2 && you == 1)
            return 0;
        else if(me == 2 && you == 3)
            return 1;
        else if(me == 3 && you == 1)
            return 1;
        else if(me== 3 && you ==2)
            return 0;
        else
            return 0;
    }
    // 1= 주먹 , 2= 보 3= 가위
    static int two (int me, int you) {
        if(me==1 && you==2)
            return 0;
        else if (me == 1 && you == 3)
            return 1;
        else if (me == 2 && you == 1)
            return 1;
        else if(me == 2 && you == 3)
            return 0;
        else if(me == 3 && you == 1)
            return 0;
        else if(me== 3 && you ==2)
            return 1;
        else
            return 0;
    }
    // 1 = 가위 2= 보 3= 주먹
    static int three (int me, int you) {
        if(me==1 && you==2)
            return 1;
        else if (me == 1 && you == 3)
            return 0;
        else if (me == 2 && you == 1)
            return 0;
        else if(me == 2 && you == 3)
            return 1;
        else if(me == 3 && you == 1)
            return 1;
        else if(me== 3 && you ==2)
            return 0;
        else
            return 0;
    }
    // 1= 가위 2= 주먹 3= 보
    static int four (int me, int you) {
        if(me==1 && you==2)
            return 0;
        else if (me == 1 && you == 3)
            return 1;
        else if (me == 2 && you == 1)
            return 1;
        else if(me == 2 && you == 3)
            return 0;
        else if(me == 3 && you == 1)
            return 0;
        else if(me== 3 && you ==2)
            return 1;
        else
            return 0;
    }
    // 1= 보 2= 주먹 3= 가위
    static int five (int me, int you) {
        if(me==1 && you==2)
            return 1;
        else if (me == 1 && you == 3)
            return 0;
        else if (me == 2 && you == 1)
            return 0;
        else if(me == 2 && you == 3)
            return 1;
        else if(me == 3 && you == 1)
            return 1;
        else if(me== 3 && you ==2)
            return 0;
        else
            return 0;
    }
    // 1 = 보 2= 가위 3= 주먹
    static int six (int me, int you) {
        if(me==1 && you==2)
            return 0;
        else if (me == 1 && you == 3)
            return 1;
        else if (me == 2 && you == 1)
            return 1;
        else if(me == 2 && you == 3)
            return 0;
        else if(me == 3 && you == 1)
            return 0;
        else if(me== 3 && you ==2)
            return 1;
        else
            return 0;
    }
    }

