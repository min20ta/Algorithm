
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int [] arr;
    static int [] ansArr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;



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
                for (int i = 0; i < n ; i++) {
                    System.out.print(arrayList.get(i));
                }
                System.exit(0);

            return;
        }

        for (int i = 4; i <=6 ; i++) {

            arrayList.add(i);
            if (possible())
                findMin(count+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    //재귀를 조건으로 컷팅해준다

    static boolean possible() {
        //n은 80까지
        int len = 1;
        while (true) {
            int end1 = arrayList.size()-1, start1 = end1-len+1;
            int end2 = start1-1, start2 = end2-len+1;

            if (start2 < 0)
                break;

            if (isEqual(start1, end1, start2, end2))
                return false;

            len++;

        }

        return true;
    }

    static boolean isEqual(int start1, int end1, int start2, int end2) {
        for (int i = 0; i <= end1-start1; i++) {
            if (arrayList.get(start1+i) != arrayList.get(start2 + i))
                return false;
        }
        return true;
    }



}




