
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int g;

    static int max = Integer.MIN_VALUE;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        HashSet<Integer> [] groups = new HashSet[g];
        ArrayList<Integer> [] peoples = new ArrayList[n+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < g; i++) {
            groups[i] = new HashSet<>();
        }
        for (int i = 0; i <= n ; i++) {
            peoples[i] = new ArrayList<>();
        }

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int p = Integer.parseInt(st.nextToken());
                groups[i].add(p);
                peoples[p].add(i);
            }
        }

        int count = 1;
        q.add(1);
        while (!q.isEmpty()) {
            int who = q.poll();

            for (int i = 0; i < peoples[who].size(); i++) {
                int group = peoples[who].get(i);
                groups[group].remove(who);

                if (groups[group].size() == 1) {
                    for (int next : groups[group]){
                        q.add(next);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}


