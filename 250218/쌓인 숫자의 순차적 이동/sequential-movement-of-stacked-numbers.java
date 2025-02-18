import java.util.*;
import java.io.*;


public class Main {
    static int[][] map;
    static int[] num;
    static pair[] display;
    static int[][] dir;
    static int[][] dir2;
    static int idx = 0;
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static int n;
    static int m;
    static int t;
    static int x = 0;
    static int y = 0;
    static int next;
    static Queue<pair> q = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<pair> list2 = new ArrayList<>();
    static ArrayList<int [][]> dirList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map= new int[n][n];
        display = new pair[n*n+1];
        num = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); //쓸모가 없을듯?
                display[map[i][j]] = new pair(i,j,0,map[i][j]);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            findMax(display[num[i]].x,display[num[i]].y, num[i]);
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                printAns(i,j);
            }
        }

    }

    static void findMax(int x, int y, int num) {

        int max = Integer.MIN_VALUE;
        int maxX = 0; int maxY = 0;
        int nx = 0; int ny = 0;

        for (int i = 0; i < 8; i++) {
            list.clear();
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {

                getNumbers(nx,ny);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > max){
                        max = list.get(j);
                        maxX = nx; maxY = ny;
                    }
                }
            }
        }
        //System.out.println(max + " "+ maxX+" "+maxY);
        //최대값 자리로 이동
        //내 위 애들 찾아서
        getUp(num);
        //이동
        list.clear();
        getNumbers(maxX,maxY);
        int curNum = list.size()-1;
        int nextNum = list2.size();
//        System.out.println("cur: "+ curNum);
//        System.out.println("next: "+ nextNum);
        if (nextNum != 0) {
            for (int i = list2.size() - 1; i >= 0; i--) {
                display[list2.get(i).num] = new pair(maxX, maxY, nextNum-- + curNum, list2.get(i).num);
            }
            list2.clear();
        }
//        for (int i = 1; i <= n*n; i++) {
////            System.out.println(i+": "+display[i].x+" "+display[i].y +" "+ display[i].howManyBack);
////        }

    }
    static void getNumbers(int x, int y) {
        for (int i = 1; i <= n*n  ; i++) {
            if (display[i].x == x && display[i].y == y)
                list.add(i);
        }
    }

    static void getUp(int num) { //상위 같이 움직이기
        int x = display[num].x;
        int y = display[num].y;
        int howManyBack = display[num].howManyBack;
        list2.add(display[num]);

        for (int i = 1 ; i <= n*n ; i++) {
            if (i != max && display[i].x == x && display[i].y == y){
                if (display[i].howManyBack > howManyBack) {
                    list2.add(display[i]);
                }
            }
        }
        Collections.sort(list2);

    }

    static void printAns(int x, int y) {
        List<pair> temp = new ArrayList<>();
        for (int i = 1; i <= n*n; i++) {
            if (display[i].x == x && display[i].y == y)
                temp.add(display[i]);
        }
        if(temp.size() == 0){
            System.out.println("None");
            return;
        }

        Collections.sort(temp);
        for (int i = temp.size()-1; i >= 0 ; i--) {
            System.out.print(temp.get(i).num+" ");
        }
        System.out.println();
    }


    static class pair implements Comparable<pair>{
        int x;
        int y;
        int howManyBack;
        int num;


        pair(int x, int y, int howManyBack, int num) {
            this.x =x;
            this.y = y;
            this.howManyBack = howManyBack;
            this.num = num;
        }

        @Override
        public int compareTo(pair p) {
            return this.howManyBack - p.howManyBack;
        }
        }
}

