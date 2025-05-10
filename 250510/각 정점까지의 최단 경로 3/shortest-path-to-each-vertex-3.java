


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int ans = 0;
    static int [][] arr;
    static int [] distance;
    static boolean[] visit;
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int alphaSize;
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<Character> set = new HashSet<>();;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        arr = new int[n+1][n+1];
        distance = new int[n+1];

        for (int i = 0; i < m; i++) {
            //시작, 끝, 가중치
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[s][e] = w;
        }

        for (int i = 1; i <= n ; i++) {
            distance[i] = (int)1e9;
        }

        distance[1] = 0 ; //시작위치

        for (int i = 1; i <= n ; i++) {

            //아직 방문하지 않은 정점 중 가장 작은 거리
            //거리배열 내 최단거리
            int minIndex = -1;
            for (int j = 1; j <=n ; j++) {
                if (!visit[j]) {
                    if (minIndex == -1 || distance[minIndex] > distance[j])
                        minIndex = j;
                }
            }
            visit[minIndex] = true;

            for (int j = 1; j <= n ; j++) {
                if (arr[minIndex][j] == 0)
                    continue;

                distance[j] = Math.min(distance[j],distance[minIndex] + arr[minIndex][j]);
            }


        }
        for (int i = 2; i <= n ; i++) {
            if (distance[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(distance[i]);
        }
       
    }


}




