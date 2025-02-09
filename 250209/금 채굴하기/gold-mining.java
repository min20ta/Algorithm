
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [] finish;
    static int [][] arr;
    static boolean cycle = false ;
    static int deleteTwo = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int ans = Integer.MIN_VALUE;

    static Queue<pair>  nextQ = new LinkedList<>();




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }


        //중심좌표하나 잡고 모든 k적용. => 중복발생

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) { //해당죄표에서 k=0,1,
                    int goldCount = mineGold(k, i, j);
                    if (notLose(k, goldCount))
                        ans = Math.max(ans, goldCount);

                }
            }
        }
//
//                while (checkKSize(k)) {
//                    q = new LinkedList<>(nextQ);
//                    whil  e (!q.isEmpty()) {
//                        pair p = q.poll();
//                        int x = p.x;
//                        int y = p.y;
//
//                        if (k == 0) {
//                            if (!(x >= 0 && x < n && y >= 0 && y < n
//                                    && !visit[x][y])) {
//                                k++;
//                                continue;
//                            }
//
//                            if (arr[x][y] == 1)
//                                gold++;
//                            visit[x][y] = true;
//
//                            if (notLose(k, gold)) {
//                                max = Math.max(max, gold);
//                            }
//                        } else {
//                            for (int l = 0; l < 4; l++) {
//                                int nx = x + dx[l];
//                                int ny = y + dy[l];
//
//                                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n
//                                        && !visit[nx][ny]))
//                                    continue;
//
//                                if (arr[nx][ny] == 1)
//                                    gold++;
//                                visit[nx][ny] = true;
//                                nextQ.add(new pair(nx, ny));
//                            }
//
//                            if (notLose(k, gold)) {
//                                System.out.println(gold);
//                                max = Math.max(max, gold);
//                            }
//
//                            k++;
//                        }
//                    }
//                }
//                ans = Math.max(ans, max);
//                System.out.println(ans);
//            }
//            }
        System.out.println(ans);
        }

    static int mineGold(int k , int x, int y) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x,y));
        visit = new boolean[n][n];
        visit[x][y] = true;

        int gold = 0;
        int depth = 0;

        while (!q.isEmpty()) {
            pair p = q.poll();
            if (arr[p.x][p.y] == 1)
                gold++;
            if (depth == k)
                continue;



            for (int j = 0; j < 4; j++) {
                int nextX = p.x + dx[j];
                int nextY = p.y + dy[j];

                if (nextX >= 0 && nextY >= 0 && nextY < n && nextX < n
                && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    q.add(new pair(nextX, nextY));

                }
            }
            depth++;




        }
        return gold;

    }

    static boolean notLose(int k, int gold) {
        int square = k*k + (k+1)*(k+1);
        int goldMoney = gold * m;

        if (square < goldMoney)
            return true;
        return false;
    }

    static boolean checkKSize (int k) {
        int size = 5 + 8*(k-1);
        if (size <= n*n)
            return true;
        return false;
    }

    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x =x;
            this.y = y;
        }
    }







}


