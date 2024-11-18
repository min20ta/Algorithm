
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jak = 0;
        int hol = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0)
                jak++;
            else
                hol++;
        }


        // 짝 짝/ 홀홀/
        // 짣홀/
        //최대 묶음수 짝홀 번갈아
        boolean one = true;
        boolean two = false;
        int group = 0;

        // 1 3/57 9/ 11 3
        // 1, 2/ 11 01
        // 하...뭐지 짝 홀 짝 홀
        //뒤에 남아있는거
       // 짝 : 0, 홀: 7
        // 2/1/2/2 불가
        //
        while (true) {
            if (one) {
                if (jak > 0) {
                    jak--;
                    group++;
                } else if (hol >= 2) {
                    group++;
                    hol -= 2;
                } else if (hol > 0) {
                    group--;
                    break;
                }
                one = false;
                two = true;
            } else if (two) {
                if (hol > 0) {
                    group++;
                    hol--;
                } else if (jak>0){
                    break;
                }

                two = false;
                one = true;
            }
        }
        System.out.println(group);
    }





}



