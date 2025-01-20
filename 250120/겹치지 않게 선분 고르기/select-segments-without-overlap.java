
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static int [][] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
             int x1 = Integer.parseInt(st.nextToken());
             int x2 = Integer.parseInt(st.nextToken());
             arr[i][0] = x1;
             arr[i][1] = x2;
        }
        //끝점 = 겹침
        //최대한 많은 선분 뽑기


        find(0);
        System.out.println(max);

    }

    static void find(int depth) {
        if(depth == n) {
            max = Math.max(max, calc());
            return;
        }

        for (int i = 0; i < 2; i++) {
            arrayList.add(i);
            find(depth+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    static int calc() {

        int [] calcArr = new int[1001];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (arrayList.get(i) == 0) {
                continue;
            } else if (arrayList.get(i) == 1) {
                int x1 = arr[i][0];
                int x2 = arr[i][1];
                sum++;

                for (int j = x1; j <=x2 ; j++) {
                    calcArr[j]++;
                }
            }
        }

        boolean flag = true;
        for (int i = 1; i <= 1000; i++) {
            if (calcArr[i] > 1){
                flag = false;
                break;
            }
        }

        if (flag)
            max = Math.max(max,sum);

        return max;
  }





}