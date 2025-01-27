
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean [] visit;
    static int [][] arr;
    static int min = Integer.MAX_VALUE;


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
        arrayList.add(0);
        visit[0] = true;
        find(1);
        System.out.println(min);
    }


//모든 지점. 정점 겹치지 않게 방문. 최소비용
    //0은 이동불가
    //열순서 구하기
    static void find(int depth) {

        if (depth == n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += arr[arrayList.get(i)][arrayList.get(i+1)];
                //System.out.println(arrayList.get(i));
            }
            if (arr[arrayList.get(n-1)][0] == 0)
                return;

            sum+= arr[arrayList.get(n-1)][0];
            //System.out.println( arrayList.get(n-1));
            //System.out.println();
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n ; i++) {
            if (!visit[i] && arr[arrayList.get(arrayList.size()-1)][i]!=0) {
                visit[i] = true;
                arrayList.add(i);
                find(depth+1);
                arrayList.remove(arrayList.size()-1);
                visit[i] = false;
            }
        }
    }
        }

















