
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
        arr = new int[n];
        ansArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        //최소점프수
        //최대 점프가능 거리
        findMin(0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void findMin(int idx){

        if (idx == n-1){
            min = Math.min(min, arrayList.size());
            return;
        }


        for (int i = 1 ; i <= arr[idx] ; i++) {
            if (idx + i >= n)
                continue;

            arrayList.add(idx+i);
            findMin(idx+i);
            arrayList.remove(arrayList.size()-1);

        }





    }    }






