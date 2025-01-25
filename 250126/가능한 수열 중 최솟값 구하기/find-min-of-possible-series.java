
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static ArrayList<Integer> arrayList = new ArrayList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        //4 5 6
        //임의의 길이 갖는 인접한 수열 동일x

        findMin(0);



    }
    static void findMin(int count) {
        if (count == n) {
            if (possible()) {
                for (int i = 0; i < n ; i++) {
                    System.out.print(arrayList.get(i));
                }
                System.exit(0);
            }

            return;
        }

        for (int i = 4; i <=6 ; i++) {
            arrayList.add(i);
            findMin(count+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    static boolean possible() {
        //n은 80까지

        for (int i = 1; i <= n/2; i++) {

            for (int j = 0; j < n; j++) {
                int count = 0;

                for (int k = j; k < j+i && k+i < n; k++) {
                    if (arrayList.get(k) == arrayList.get(k+i)){
                        count++;
                    }
                }
                if (count == i)
                    return false;
            }
        }

        return true;
    }



}




