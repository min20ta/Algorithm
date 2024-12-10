
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

        String str = br.readLine();



        //월요일
        //
        int [] month =  {31,29,31,30,31,30,31,31,30,31,30,31};
        String [] day = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

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
        int diff =second-first;
        int diff2 = findDay2-findDay1;

        int week = diff /7;
        boolean flag = true;

        for (int i = 1; i < 7; i++) {

            if (str.equals(day[(diff2+i)%7])){
                flag = false;
                break;
            }

        }
        if (flag)
            week++;



        System.out.println(week);


    }
}






