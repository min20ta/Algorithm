
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int c;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[] ansArr;
    static int[][] copyArr;
    static int ans = 0;
    static boolean[] visit;
    static int root;
    static int peopleNum;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> colList = new ArrayList<>();

    static int rowA;
    static int rowB;
    static int colA;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //m개열. 겹치지x. 각 최대 무게 c.
        // 가치 w^2. 제곱의 합들
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
               arr[i][j]=  Integer.parseInt(st.nextToken());
            }
        }

        //완탐, 조합
        //행 뽑고, 열 뽑고 -> 행 같을 때/ 다를때
        //숫자로 표현해서 차이 m이상 나도록 2개 뽑기

        for (int i = 0; i < n; i++) { //x1
            for (int j = 0; j < n; j++) { //y1
                for (int k = 0; k < n; k++) { //x2
                    for (int l = 0; l < n; l++) { //y2
                        if (possible(i,j,k,l)) {
                            int sum = 0;
                            maxVal = Integer.MIN_VALUE;
                            findMax(i,j,0,0,0);
                            sum += maxVal;

                            maxVal = Integer.MIN_VALUE;
                            findMax(k,l,0,0,0);
                            sum += maxVal;

                            max = Math.max(max , sum);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
    static boolean possible(int x1, int y1, int x2, int y2) {

        if(y1 >= y2)
            return false;

        if (x1 == x2 && y1+(m-1) >= y2) //같은행일때
            return false;

        if (y1 + m-1 >= n || y2 + m-1 >= n) //범위 벗어나는지
            return false;

        return true;
    }

    static void findMax(int x, int y, int idx, int weight, int val) {
        //최대 무게 되는 것들 열 고르기
        if (idx == m) {
            if (weight <= c)
                maxVal = Math.max(maxVal, val);
            return;
        }

        // 선택
        findMax(x,y, idx+1, weight+arr[x][y+idx], val+arr[x][y+idx]*arr[x][y+idx]);
        //노선택
        findMax(x,y, idx+1, weight, val);

    }


    
}