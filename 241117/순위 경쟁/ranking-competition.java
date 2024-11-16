import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int aScore = 0;
        int bScore = 0;
        int cScore = 0;
        int ans = 0;
        String what = "ABC";

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(c == 'A')
                aScore+= num;
            else if(c == 'B')
                bScore+= num;
            else if(c == 'C')
                cScore+= num;
            int max = Math.max(aScore, Math.max(bScore, cScore));

            if (aScore == bScore && bScore == cScore) {
                if (!what.equals("ABC")) {
                    ans++;
                    what = "ABC";
//                    System.out.println("ABC");
                }
            }else if (aScore == bScore && aScore == max) {
                if (!what.equals("AB")) {
                    ans++;
                    what = "AB";
//                    System.out.println("AB");
                }
            }else if (aScore == cScore && aScore == max) {
                if (!what.equals("AC")) {
                    ans++;
                    what = "AC";
//                    System.out.println("AC");
                }
            }else if (bScore == cScore && bScore == max) {
                if (!what.equals("BC")) {
                    ans++;
                    what = "BC";
//                    System.out.println("BC");
                }
            }else if (aScore == max) {
                if (!what.equals("A")) {
                    ans++;
                    what = "A";
//                    System.out.println("A");
                }
            }else if (bScore == max) {
                if (!what.equals("B")) {
                    ans++;
                    what = "B";
//                    System.out.println("B");
                }
            } else if (cScore == max) {
                if (!what.equals("C")) {
                    ans++;
                    what = "C";
//                    System.out.println("C");
                }
            }
        }
        System.out.println(ans);

    }
}





