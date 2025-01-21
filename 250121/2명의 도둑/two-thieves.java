
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static int m;
    static int c;
    static int [][] arr;
    static int [] colA = new int[2];
    static int [] colB = new int[2];

    static ArrayList<Integer> lines = new ArrayList<>();
    static ArrayList<Integer> selectedLines = new ArrayList<>();
    static ArrayList<Integer> selectedColLines = new ArrayList<>();
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }



        //2명이 행고르고, m개의 열고르고, c까지, 최대구하기
        findMax(0);
        System.out.println(max);

    }

    static void findMax(int count) {
        if (count == 2){
            int a = selectedLines.get(0);
            int b = selectedLines.get(1);

            //열 고르기
            if (a == b) {
                    findColOne(0, a);
            }else if (a!= b){
                findColTwo(0, a,b);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            selectedLines.add(i);
            findMax(count+1);
            selectedLines.remove(selectedLines.size()-1);
        }


    }

    //m개 열 고르기
    // 열 같을 떄
    static void findColOne(int count, int row) {
        if (count == 2){
            int a = selectedColLines.get(0);
            int b = selectedColLines.get(1);

            if (a<b && a > 0 && b >=a+1 && b <= n-2){
                colA[0] = arr[row][a-1];
                colA[1] = arr[row][a];

                colB[0] = arr[row][b];
                colB[1] = arr[row][b+1];

//                System.out.println(row+" "+colA[0]+ " "+ colA[1] + colB[0]+" "+ colB[1] );
                calMax();
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            selectedColLines.add(i);
            findColOne(count+1,row);
            selectedColLines.remove(selectedColLines.size()-1);
        }
    }

    //열 다를 때
    static void findColTwo(int count, int row1, int row2) {

        if (count == 2) {
            int a = selectedColLines.get(0);
            int b = selectedColLines.get(1);

            if (a >= 0 && a <= n-2 && b >= 0 && b <= n-2){
                colA[0] = arr[row1][a];
                colA[1] = arr[row1][a+1];

                colB[0] = arr[row2][b];
                colB[1] = arr[row2][b+1];

               // System.out.println(row1+" "+colA[0]+ " "+ colA[1]+ " "+ row2+" "+colB[0]+" "+ colB[1] );
                calMax();
            }
            return;
        }



        for (int i = 0; i < n; i++) {
            selectedColLines.add(i);
            findColTwo(count+1,row1,row2);
            selectedColLines.remove(selectedColLines.size()-1);
        }

    }


    static void calMax() {

        int cMaxA = Integer.MIN_VALUE;

        int a1 = colA[0];
        int a2 = colA[1];

        if (a1+a2 <= c)
            cMaxA = a1*a1+a2*a2;
        else {
            cMaxA = Math.max(a1,a2)*Math.max(a1,a2);
        }

       // System.out.print(colA[0]+ " "+ colA[1] +" "+ cMaxA+" ");
        int cMaxB = Integer.MIN_VALUE;

        int b1 = colB[0];
        int b2 = colB[1];

        if (b1+b2 <= c)
            cMaxB = b1*b1+b2*b2;
        else {
            cMaxB = Math.max(b1,b2)*Math.max(b1,b2);
        }
        //System.out.print(colB[0]+" "+ colB[1]+ " "+ cMaxB );
        max = Math.max(max,cMaxA + cMaxB);
        

    }



}