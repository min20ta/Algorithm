import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int [][] arr = new int[m+1][2];
        Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            int c = 'A'+i;
            set.add((char)c);
        }



        for (int i = 1 ; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken().charAt(0);
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //사전순 정렬
        // p번째 메시지 안읽은사람
        //c메시지 안읽은사람
        for (int i = p ; i <= m ; i++) {
            char name = (char)arr[i][0];
            set.remove(name);
        }


        if (arr[p][1] == 0) {
            System.out.println();
        }else {
            char [] cArr = new char[set.size()];
            int j = 0;

            for (Character c : set) {
                cArr[j] = c;
                j++;
            }

            Arrays.sort(cArr);

            for (char c : cArr) {
                System.out.print(c+" ");
            }
        }






    }
    }