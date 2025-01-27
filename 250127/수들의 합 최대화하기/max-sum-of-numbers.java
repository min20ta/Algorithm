
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [][] arr;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        find(0);
        System.out.println(max);
    }


    //각 행에 넣고, 열이 겹치면 안됨
    //열 순서 구하기
    static void find(int depth) {

        if (depth == n){
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum+= arrayList.get(i);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arrayList.add(arr[depth][i]);
                find(depth+1);
                arrayList.remove(arrayList.size()-1);
                visit[i] = false;
            }
        }
    }
        }










