
import java.util.*;
import java.io.*;



public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    //n, e, s, w

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        //최종 위치
        node first = new node(0,0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (d== 'N') {
                while(num -- > 0) {
                    first.x += dx[0];
                    first.y += dy[0];
                }
            }else if (d == 'E') {
                while(num -- > 0) {
                    first.x += dx[1];
                    first.y += dy[1];
                }
            }else if (d == 'S') {
                while(num -- > 0) {
                    first.x += dx[2];
                    first.y += dy[2];
                }
            }else {
                while(num -- > 0) {
                    first.x += dx[3];
                    first.y += dy[3];
                }
            }


        }
        System.out.println(first.x+" "+ first.y);
    }
    static  class node {
        int x;
        int y;

        node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
