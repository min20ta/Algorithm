import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

       //최대한 멀리
        //공석여부 -> 한명배치-> 최대한거리두기 간격출력
        // 양끝에는 항상 사람있음


        int [] arr = new int[n];
        int start = 0;
        int end = 0;
        int num = 0;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>();

        //인덱스를 저장
       for (int i = 0 ; i < n ; i++) {
           if (str.charAt(i)== '1'){
               list.add(i);
           }
       }
       for(int i = 1 ; i < list.size() ;i++) {

           int sub = list.get(i)-list.get(i-1)-1;

           if (max < sub) {
               max = sub;
               start = list.get(i);
               end = list.get(i-1);
           }
       }

        if(max%2 == 1) {
            max =  max/2+1;
        }else {
           max = max/2;
        }
//101001
        
        int min = max;
        for(int i = 1 ; i < list.size() ;i++) {

            int sub = list.get(i)-list.get(i-1);

            if (min > sub) {
                min = sub;
            }
        }

        System.out.println(min);
    }
    }