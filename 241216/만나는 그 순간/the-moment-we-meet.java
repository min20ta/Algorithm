
import java.util.*;
import java.io.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arrA = new int[1000001];
        int [] arrB = new int[1000001];
        int indexA = 0;
        int indexB = 0;
        int timeA = 0;
        int timeB = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (d == 'R') {
                for (int j = indexA; j < indexA+num; j++) {
                   arrA[timeA++] = j;
                }
                indexA+= num;
            } else if (d == 'L') {
                for (int j = indexA; j > indexA-num; j--){
                    arrA[timeA++] = j;
                }
                indexA-= num;
            }
        }
        arrA[timeA] = indexA;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (d == 'R') {
                for (int j = indexB; j < indexB+num; j++) {
                    arrB[timeB++] = j;
                }
                indexB+= num;
            } else if (d == 'L') {
                for (int j = indexB; j > indexB-num; j--){
                    arrB[timeB++] = j;
                }
                indexB-= num;
            }
        }
        arrB[timeB] = indexB;


        int answer = -1;
        // 같은거 처리 어케
        for (int i = 1; i <= Math.max(timeA,timeB); i++) {
            //System.out.println(arrA[i] + " "+arrB[i]);
            if (arrA[i] == arrB[i] ) {
                answer = i;
                break;
            }
        }

            System.out.println(answer);

    }
}
