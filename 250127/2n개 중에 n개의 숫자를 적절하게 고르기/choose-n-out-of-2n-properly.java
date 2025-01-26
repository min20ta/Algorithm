
import java.util.*;
import java.io.*;


public class Main {

    static int n ;

    static int [] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int sumAll = 0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sumAll+= num;
        }
        //n개씩 2개그룹]
        findMin(0,0);
        System.out.println(min);

    }
    static void findMin(int depth, int start) {


        if (depth == n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum+= arrayList.get(i);
            }
            int sum2 = sumAll - sum;
//            System.out.println(sum+" "+sum2+" ");
            int diff = Math.abs(sum - sum2);
            min = Math.min(min, diff);

            return;

    }
        //정해진 개수가 있을때
        //중복조심
        for (int i = start; i < 2*n; i++) {
            arrayList.add(arr[i]);
            findMin(depth+1,i+1);
            arrayList.remove(arrayList.size()-1);
        }

        }


        }












