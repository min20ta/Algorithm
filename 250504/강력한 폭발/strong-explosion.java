

import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean[] visit;
    static int time = 0;
//    static int[] dx = {0, 1, -1, 0};
//    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k;
    static int end;
    static int [][] arr;
    static int[][] tempArr;
    static int[] L;
    static int[] R;
    static int size = 0;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();
    static Queue<pair> queue = new LinkedList<>();
    static Queue<pair> tempQueue = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        tempArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];
                if (arr[i][j] == 1) {
                    queue.add(new pair(i, j));
                    tempQueue.add(new pair(i,j));
                }
            }
        }
        size = queue.size();
        whatBomb(0);
        System.out.println(max);

        //폭탄 최대화
        //파란색 폭비ㅏㄹ
    }
    static void whatBomb(int index) {

        if (index == size){
            max = Math.max(max,getBomb());
            return;
        }

        for (int i = 1; i <= 3 ; i++) {
            list.add(i);
            whatBomb(index+1);
            list.remove(list.size()-1);
        }
    }

    static int getBomb() {
        int [] dx ;
        int [] dy ;

        for (int i = 0; i < size; i++) {
            int num = list.get(i);
            pair p = tempQueue.poll();
            int x = p.x;
            int y = p.y;

            if (num == 1){
                dx = new int []{0,-1,-2,1,2};
                dy = new int[] {0,0,0,0,0};
            }else if (num == 2) {
                dx = new int []{0,0,1,0,-1};
                dy = new int[] {0,1,0,-1,0};
            }else  {
                dx = new int []{0,-1,1,1,-1};
                dy = new int[] {0,1,1,-1,-1};
            }

            for (int j = 0; j < 5; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    tempArr[nx][ny] = -1;
                }
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempArr[i][j] == -1) {
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        tempQueue = new LinkedList<>(queue);

        return count;

    }
    static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



