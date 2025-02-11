
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

//       arr = new int[n][m];
        List<LinkedList<Integer>> list = new ArrayList<>();
        List<LinkedList<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());
            list2.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(i).add(num);
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); r--;
        int c = Integer.parseInt(st.nextToken()); c--;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());


        //필요한 라인 리스트에 넣기
        LinkedList<pair> lineList = new LinkedList<>();
        int [] weight = {m1,m2,m3,m4};
        int x = r; int y = c;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < weight[i] ; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    lineList.add(new pair(nx,ny,list.get(nx).get(ny)));
                    x = nx; y = ny;
                }
            }
        }
        lineList.addFirst(lineList.removeFirst());

        if (dir == 0) //반시계 회전
            lineList.addFirst(lineList.removeLast());
        else
            lineList.addLast(lineList.removeFirst());

        //다시 그래프에 반영
        x = r; y = c;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < weight[i] ; j++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    list.get(nx).set(ny, lineList.get(index++).len);
                    x = nx; y = ny;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(list.get(i).get(j)+" ");
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