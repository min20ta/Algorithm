
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static int [][] arr;
    static int [][] real;
    static Queue<pair> q = new LinkedList<>();
    static int count = 0;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        real = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                real[i][j] = Integer.parseInt(st.nextToken());
                if (real[i][j] == 1) {
                    q.add(new pair(i, j));
                    count++;
                }
            }
        }


        find(0);
        System.out.println(max);


    }
    static void find(int depth) {
        if (depth == count) {

            //배열복사
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (real[i][j] == 1)
                        arr[i][j] = 1;
                }
            }

            for (int i = 0; i < count; i++) {
                pair p = q.poll();

                if (arrayList.get(i) == 1){
                    firstBom(p.x, p.y);
                }else if (arrayList.get(i) == 2) {
                    secondBom(p.x, p.y);
                } else if (arrayList.get(i) == 3) {
                    thirdBom(p.x, p.y);
                }
                //다시 되돌리기!
                q.add(p);
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //System.out.print(arr[i][j]+" ");
                    if (arr[i][j] == 1)
                        sum++;
                }
                //System.out.println();
            }
            //System.out.println();

            max = Math.max(max, sum);

            return;
        }

        for (int i = 1; i <= 3; i++) {
            arrayList.add(i);
            find(depth+1);
            arrayList.remove(arrayList.size()-1);
        }
    }
    static void firstBom(int x, int y) {
        int [] dx = {-1,-2,1,2};
        int [] dy = {0,0,0,0};

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newx < n && newy >= 0 && newy < n){
                arr[newx][newy] = 1;
            }
        }
    }

    static void secondBom(int x, int y) {
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newx < n && newy >= 0 && newy < n){
                arr[newx][newy] = 1;
            }
        }
    }

    static void thirdBom(int x, int y){
        int [] dx = {-1,-1,1,1};
        int [] dy = {1,-1,-1,1};


        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newx < n && newy >= 0 && newy < n){
                arr[newx][newy] = 1;
            }
        }

    }

    static class pair{
        int x;
        int y;

        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }}