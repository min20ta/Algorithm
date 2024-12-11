import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n =st.nextToken();
        int gin = Integer.parseInt(st.nextToken());

        String answer = "";
        int [] ginAnswer = new int[20];
        int cnt = 0;

        if(gin == 8) {
            int num = Integer.parseInt(n);
            answer = Integer.toOctalString(num);
            System.out.println(answer);
        }
        else if(gin == 4) {
            int num = Integer.parseInt(n);

            while (true) {
                if (num  < 4) {
                    ginAnswer[cnt] = num;
                    break;}
                ginAnswer[cnt++] = num%4;
                num/=4;
            }
            for (int k = cnt; k>= 0 ; k--) {
                System.out.print(ginAnswer[k]+ "");
            }

        }



    }


}
