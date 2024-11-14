import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 3명. 양쪽중 한사람 움직
        // 연속된 숫자
        //최대이동횟수
        int count = 0;


        while(true) {
            int first = b - a;
            int second = c - b;

            //4,1
            //1 4 5
            //1 3 4
            // 1 2 3
            if (first == 1 && second == 1)
                break;

            if (first > second) {
                c = b-1;
                int temp = b;
                    b = c;
                    c = temp;

            }else if (first <= second) {
                a = b+1;
                int temp = b;
                b = a;
                a = temp;
            }
            count++;
        }
        System.out.println(count);

    }
    }

