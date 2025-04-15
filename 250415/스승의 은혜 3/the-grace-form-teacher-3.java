
import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] depth ;
    static boolean[] visit;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0,0, 1};
    static int n;
    static int m;
    static int b;
    static int end;
    static int [] p;
    static int [] s;


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        //n명 학생 b예산
        // 선물p 짝수, 배송비s
        // 하나 선물 반값
        // 최대 명수
        p = new int[n];
        s = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        //반값 대상
        for (int i = 0; i < n; i++) {
            max = Math.max(checkNum(i),max);
        }

        System.out.println(max);


    }
    static int checkNum(int halfPerson) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == halfPerson) continue;
            list.add(p[i]+s[i]);
        }
        list.add(p[halfPerson]/2+ s[halfPerson]);
        Collections.sort(list);

        int sum = 0;
        int person = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            person++;

            if (sum > b) {
                person--;
                break;
            }
           // System.out.println(sum+" "+person);
        }

        return person;
    }

}

