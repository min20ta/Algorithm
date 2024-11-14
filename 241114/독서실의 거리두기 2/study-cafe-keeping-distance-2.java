import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        //n 공석 최대한거리

        //양끝 0인 경우 고려해 봐야함

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1')
                arrayList.add(i);
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int startidx = 0;

        for (int i = 1; i < arrayList.size(); i++) {
            int size = arrayList.get(i) - arrayList.get(i - 1);
            if (max < size) {
                max = size;
                start = arrayList.get(i - 1);
                startidx = i;
            }

        }

        int temp = 0;
        int flagFist = 0;
        if (str.charAt(0) == '0') {
                temp = arrayList.get(0);
                flagFist = 1;
            }



        int flagSecond = 0;

        if (str.charAt(n - 1) == '0') {
            if(temp<(n-1)-arrayList.get(arrayList.size() - 1)) {
                temp = (n-1)-arrayList.get(arrayList.size() - 1);
                flagSecond = 1;
                flagFist = 0;
            }
        }

        //이거 둘을 밑으로 보내야함

            //10101

            int index = start + max / 2;
            arrayList.add(startidx, index);


            int min = max;
            for (int i = 1; i < arrayList.size(); i++) {
                int size = arrayList.get(i) - arrayList.get(i - 1);
                if (min > size) {
                    min = size;
                }
            }


        if (flagFist == 1 && min < temp) {
            arrayList.remove(startidx);

            for (int i = 1; i < arrayList.size(); i++) {
                int size = arrayList.get(i) - arrayList.get(i - 1);
                if (temp > size) {
                     temp = size;
                }
            }

            System.out.println(temp);
        } else if (flagSecond == 1 && min < temp) {
            arrayList.remove(startidx);
            for (int i = 1; i < arrayList.size(); i++) {
                int size = arrayList.get(i) - arrayList.get(i - 1);
                if (temp > size) {
                    temp = size;
                }
            }

            System.out.println(temp);
        }else {
            System.out.println(min);
        }

    }
}


