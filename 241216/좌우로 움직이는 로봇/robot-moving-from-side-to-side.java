
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
        int indexA = 1;
        int indexB = 1;
        // 초기준 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if (d=='L') {
                while(t-- > 0) {
                    arrA[indexA] = arrA[indexA-1] -1 ;
                    indexA++;
                }


            } else if (d == 'R') {
                while(t-- > 0) {
                    arrA[indexA] = arrA[indexA-1] + 1 ;
                    indexA++;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if (d=='L') {
                while(t-- > 0) {
                    arrB[indexB] = arrB[indexB-1] -1 ;
                    indexB++;
                }


            } else if (d == 'R') {
                while(t-- > 0) {
                    arrB[indexB] = arrB[indexB-1] + 1 ;
                    indexB++;
                }


            }
        }

        int answer = 0 ;
        indexA--;
        indexB--;

        for (int i = 1; i < 1000001; i++) {
            if (i >= indexA && i < indexB) {
                if (arrA[indexA] == arrB[i] && arrA[indexA-1] != arrB[i-1]) {
                    answer++;
                    //System.out.println(i);
                }
            }else if (i < indexA && i >= indexB) {
                if (arrA[i] == arrB[indexB] && arrA[i-1] != arrB[indexB-1]) {
                    answer++;
                    //System.out.println(i);
                }
            }else if (i >= indexA && i >= indexB) {
                if (arrA[indexA] == arrB[indexB] && arrA[indexA-1] != arrB[indexB-1]) {
                    answer++;
                    //System.out.println(i);
                }
            }else {

                if (arrA[i] == arrB[i] && arrA[i-1] != arrB[i-1]) {
                    answer++;
                    //System.out.println(i);
                }
            }
        }

        System.out.println(answer);








    }
     
}
