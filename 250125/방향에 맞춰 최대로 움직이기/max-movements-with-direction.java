
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int [][] arr;
    static int [][] dirArr;
    static int r;
    static int c;

    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static Queue<pair> queue = new LinkedList<>();

    static int [] dx = {0,-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,0,1,1,1,0,-1,-1,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        dirArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                dirArr[i][j] = num;
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;



        //시작점에서 방향에 있는 숫자 중 더 큰것만 가능
        queue.add(new pair(r,c,0));
        findMax();
        if (max == Integer.MIN_VALUE)
            System.out.println(0);
        else 
            System.out.println(max);

        }

        static void findMax() {



            while(!queue.isEmpty()) {
                pair p = queue.poll();
                int newx = p.x;
                int newy = p.y;
                int dir = dirArr[newx][newy];


                while(true) {
                    int x = newx + dx[dir];
                    int y = newy + dy[dir];

                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (arr[x][y] > arr[p.x][p.y]) {
                            //System.out.print(x+" "+y+" ");
                            max = Math.max(max, p.count + 1);
                            //System.out.print(p.count+1+" ");
                            //System.out.println();
                            queue.add(new pair(x, y, p.count + 1));
                        }
                        newx = x;
                        newy = y;
                    }else
                        break;
                }
            }

        }

        static class pair {
        int x;
        int y;
        int count;

        pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        }
    }




