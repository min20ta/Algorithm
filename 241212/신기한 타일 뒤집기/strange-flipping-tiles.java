
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] wbArr = new int[200002][2];
        int [] whatIsLast = new int[200002];
        int start = 100000;
        int gray = 0;

        // L 왼 : 흰색
        // R 오 : 검
        // 흰 검 2번씩 -> 회색. 더 이상 안바뀜
        //흰 1 검2 흰3 검4 회5

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            //현재 위치 타일포함. 같은방향으로 할수가 ???
            if (d == 'L') {
                for (int j = start; j > start-num ; j--) {

                    wbArr[j][0]++;
                    whatIsLast[j] = 2;

                }
                start = start-num +1;
            }else if (d == 'R') {
                for (int j = start; j < start + num ; j++) {
                        wbArr[j][1]++;
                        whatIsLast[j] = 3;

                }
                start = start + num -1;
            }
        }


        int white = 0;
        int black = 0;
        for (int i = 0; i <200001 ; i++) {

        if (whatIsLast[i] == 3)
                black++;
            else if (whatIsLast[i] == 2)
                white++;
        }

        System.out.println(white+" "+black);
    }


}




