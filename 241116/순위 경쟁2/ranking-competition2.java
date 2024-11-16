import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int aScore = 0;
        int bScore = 0;
        int ans = 0;
        String what = "AB";

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (c == 'A')
                aScore += num;
            else if(c == 'B')
                bScore += num;

            if(aScore == bScore) {
                if (!what.equals("AB")) {
                  
                    ans++;
                    what = "AB";

                }
            }
            else if(aScore < bScore) {
                if (!what.equals("B")) {
                    ans++;
                    what = "B";
                }
                }
            else if(aScore > bScore) {
                if (!what.equals("A")) {
                    ans++;
                    what = "A";
                }

            }




        }
        System.out.println(ans);


    }
}

