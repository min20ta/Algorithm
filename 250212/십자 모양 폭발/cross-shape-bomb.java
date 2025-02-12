
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{0,-1,0,1};
    static int [] dy = new int[]{1,0,-1,0};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        int [][] temp = new int[n][n];
        List<LinkedList<Integer>> list = new ArrayList<>();
//        List<LinkedList<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());

        }

        for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(i).add(num);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int time = list.get(r).get(c)-1;


        list.get(r).set(c,0);

            for (int i = 0; i < 4; i++) {
                int x = r; int y = c;
                for (int j = 0; j < time; j++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        list.get(nx).set(ny,0);
                        x = nx; y = ny;
                    }
                }
            }



        for (int i = 0; i < n; i++) { //열
            int index = n-1;
            for (int j = n-1; j >= 0; j--) { //행
                if (list.get(j).get(i) == 0)
                    continue;
                temp[index--][i] = list.get(j).get(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }


    }

    static class pair{
        int x;
        int y;
        int len;


        pair(int x, int y , int len)
        {
           this.x = x;
           this.y = y;
           this.len = len;
        }
    }


    }