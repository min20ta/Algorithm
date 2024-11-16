
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
                }
            }else if (aScore == bScore) {
                if (!what.equals("AB")) {
                    ans++;
                    what = "AB";
                }
            }else if (aScore == cScore) {
                if (!what.equals("AC")) {
                    ans++;
                    what = "AC";
                }
            }else if (bScore == cScore) {
                if (!what.equals("BC")) {
                    ans++;
                    what = "BC";
                }
            }else if (aScore == max) {
                if (!what.equals("A")) {
                    ans++;
                    what = "A";
                }
            }else if (bScore == max) {
                if (!what.equals("B")) {
                    ans++;
                    what = "B";
                }
            } else if (cScore == max) {
                if (!what.equals("C")) {
                    ans++;
                    what = "C";
                }
            }
        }
        System.out.println(ans);

    }
}


