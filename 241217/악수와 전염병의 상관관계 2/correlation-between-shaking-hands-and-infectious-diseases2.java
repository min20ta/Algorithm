
import java.util.*;
import java.io.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        People [] arr = new People[t];
        int [][] count = new int[n+1][2];
        int [] answer = new int[n+1];

        //class만들어서 time기준 정렬
        //사람당 카운트 할수있도록 뭐가 있어야 할거같
        //5 2 3
        //6 2 4
        //7 1 2
        //
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new People(time,x, y);


        }

        Arrays.sort(arr, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.time - o2.time;
            }
        });
        count[p][1] = 1; //처음 감염자
        answer[p] = 1;

        //time기준 정렬
        //누구의 감염횟수가 증가하는거?
        //감영자가 되고 나서 부터 횟수증가
        // 1 1 2
        // 2 1 2
        // 3 1 2
        // 4 2 3
        // k=2, p=1
        // 1-2, 2-2, 3-0
        //들어갈때 허점
        for (int i =0 ; i < t ;i++) {
                if(count[arr[i].x][0] < k && count[arr[i].y][0] < k && count[arr[i].x][1] == 1 && count[arr[i].y][1] == 1) { //감염자인지
                    count[arr[i].y][0]++; //감염횟수+1
                    count[arr[i].x][0]++;
                } else if(count[arr[i].x][0] < k && count[arr[i].x][1] == 1){
                    count[arr[i].x][0]++; //감염횟수+1
                    count[arr[i].y][1] = 1; //감염자로
                    answer[arr[i].y] = 1;
                } else if(count[arr[i].y][0] < k && count[arr[i].y][1] == 1) { //감염자인지
                    count[arr[i].y][0]++; //감염횟수+1
                    count[arr[i].x][1] = 1; //감염자로
                    answer[arr[i].x] = 1;
            }

        }

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i]);
        }
        //n명 개발자
        //k. 1명 감염후 k번동안 만 전염
        //p 처음 감염된 사람
        //t

        //

        //누가 최종적으로 전염병에 걸렸는지 출력
        //전염 + 전염 -> 감염횟수+1. 재감염 x




    }
    static class People {
        int time;
        int x;
        int y ;

        People(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

}
