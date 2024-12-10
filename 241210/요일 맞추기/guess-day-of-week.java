
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());



        //월요일
        //
        int [] month =  {31,28,31,30,31,30,31,31,30,31,30,31};
        int first=0 ;
        int calMonth = 1;

        for (int i = 0; i < 12; i++) {

            if (calMonth == m1){
                break;
            }
            calMonth++;
            first+=month[i];
        }

        first+=d1;


        int second=0 ;
        calMonth = 1;

        for (int i = 0; i < 12; i++) {

            if (calMonth == m2){
                break;
            }
            calMonth++;
            second+=month[i];
        }

        second+=d2;

        int findDay1 = first %7;
        int findDay2 = second % 7;
       

            if (findDay1 == findDay2) {
                System.out.println("Mon");
            } else if (findDay1 + 1 == findDay2 || findDay1 - 6 == findDay2) {
                System.out.println("Tue");
            }else if (findDay1 + 2 == findDay2 || findDay1 - 5 == findDay2) {
                System.out.println("Wed");
            }
            else if (findDay1 + 3 == findDay2 || findDay1 - 4 == findDay2) {
                System.out.println("Thu");
            }
            else if (findDay1 + 4 == findDay2 || findDay1 - 3 == findDay2) {
                System.out.println("Fri");
            }
            else if (findDay1 + 5 == findDay2 || findDay1 - 2 == findDay2) {
                System.out.println("Sat");
            }
            else if (findDay1 + 6 == findDay2 || findDay1 -1 == findDay2) {
                System.out.println("Sun");
            }






    }
}



