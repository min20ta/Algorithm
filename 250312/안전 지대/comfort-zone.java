
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;


public class Main {

    static pair [] xArr;
    static int[] x2;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int k;
    static int q;
    static int max = Integer.MIN_VALUE;


    static int[] depth = new int[50001];
    static int[][] parent ;
    static int[][] arr;
    static int[][] copyArr;
    static int[][] ans;
    static boolean [][] visit;
    static int root;
    static int peopleNum;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        //k이하는 물에 잠김 k뺐을때 마을수
        //답 : 마을수 최대가 되는 k. 여러개면 작은 k
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        pair [] ans = new pair[100];
        int index = 0;

        for (int k = 1; k <= 100 ; k++) {
            visit = new boolean[n][m];
            int groupNum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] > k) {
                        visit[i][j] = true;
                        dfs(i, j, k);
                        groupNum++;
                    }
                }
            }
            ans[index++] = new pair(k,groupNum);
        }
        //마을개수, 사람수

        Arrays.sort(ans, new Comparator<pair>(){
            @Override
            public int compare(pair p1, pair p2) {
                if (p2.group == p1.group)
                    return p1.k - p2.k;
                return p2.group - p1.group;
            }
        });

        System.out.println(ans[0].k + " "+ ans[0].group);



    }

    static void dfs(int x, int y, int k) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visit[nx][ny] && arr[nx][ny] > k) {
                    visit[nx][ny] = true;
                    dfs(nx,ny, k);
                }
            }
        }
    }

    static class pair{
        int k;
        int group;

        pair(int k, int group) {
            this.k= k;
            this.group = group;
        }
    }
}