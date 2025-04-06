
import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Integer>[][] arr ;
    static int[] move;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0,-1,-1,1,1};
    static int[] dy = {-1, 0,0, 1,-1,1,1,-1};
    static int n;
    static int m;
    static int g;
    static int x;
    static int y;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new ArrayList[n][n];
        move = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            findLocation(move[i]);  //x,y좌표
            moveToBiggest(move[i]);  //최대찾기
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j].isEmpty())
                    System.out.println("None");
                else {
                    for (int k = 0; k < arr[i][j].size(); k++) {
                        System.out.print(arr[i][j].get(k)+" ");
                    }
                    System.out.println();
                }

            }
        }

    }

    static void moveToBiggest(int num) {
        max = Integer.MIN_VALUE;
        int maxX = -1; int maxY = -1;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                //최대찾기
                for (int j = 0; j < arr[nx][ny].size(); j++) {
                    if (max < arr[nx][ny].get(j)) {
                        max = arr[nx][ny].get(j);
                        maxX = nx;
                        maxY = ny;
                    }
                }

            }
        }


        if (max == Integer.MIN_VALUE)
            return;

        //옮기기 및 삭제
        int index = arr[x][y].indexOf(num);
        for (int j = index; j >= 0; j--) {
            arr[maxX][maxY].add(0,arr[x][y].get(j));
        }
        for (int j = 0; j <= index; j++) {
            arr[x][y].remove(Integer.valueOf(arr[maxX][maxY].get(j)));
        }

    }

    static void findLocation(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < arr[i][j].size(); k++) {
                    if (arr[i][j].get(k) == num) {
                        x = i;
                        y = j;
                        return;
                    }
                }
            }
        }
    }


}


