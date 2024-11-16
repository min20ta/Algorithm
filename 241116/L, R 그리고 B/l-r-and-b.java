import java.util.*;
import java.io.*;


public class Main {

    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static char [][] arr ;
    static boolean [][] visit = new boolean[10][10];
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[10][10];
//        arr[i] = br.readLine().toCharArray();
        Node start = null;

        for (int i =  0 ; i < 10 ; i++) {
            String str = (br.readLine());
            for (int j = 0 ; j < 10; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'L') {
                    start = new Node(i,j,0);
                }
            }
        }

        bfs(start);
        // 10*10, lrb.
        // l 이 r 피해서 b로 가는 최단거리 /.개수
        // 상하좌우 만 가능

        System.out.println(ans-1);



    }
    static class Node{
        int x ;
        int y ;
        int count ;

        Node(int x , int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }



    static void bfs (Node start) {

        Queue <Node> queue = new LinkedList<>();
        queue.add(start);
        visit[start.x][start.y] = true;



        while(!queue.isEmpty()) {
            Node node =queue.poll();

            if (arr[node.x][node.y] == 'B') {
                ans = node.count;
                break;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int newx = node.x + dx[i];
                int newy = node.y + dy[i];

                if (newx >= 0 && newx < 10 && newy >= 0 && newy <10){
                    if (!visit[newx][newy] && arr[newx][newy] != 'R') {
                        visit[newx][newy] = true;
                        queue.add(new Node(newx,newy,node.count + 1));

                    }
                }
            }
        }
    }
}


