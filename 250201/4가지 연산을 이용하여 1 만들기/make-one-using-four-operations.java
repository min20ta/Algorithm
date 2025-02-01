
import java.util.*;
import java.io.*;


public class Main {

    static int n ;

    static boolean [] visit;
    static boolean [][] kVisit;
    static int [] arr;
    static int [][] lenArr;
    static int [] dx ={0,1,0,-1};
    static int [] dy ={-1,0,1,0};
    static Queue<Integer> q = new LinkedList<>();
    static int min = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q.add(n);
        arr = new int[2000002];
        visit = new boolean[2000002];
        //4가지 연산 최소-> 1만들기
        //+-1 , 2로 나누어 떨어질 경우 /2, 3으로 나누어 떨어질 경우 /3

        bfs();
        if (n == 1)
            System.out.println(0);
        else
            System.out.println(arr[1]);



    }



    static void bfs() {

        while (!q.isEmpty()) {
            int num = q.poll();
            int newNum = num;

            for (int i = 0; i < 4; i++) {

                if (i == 0)
                    newNum = num+1;
                else if(i==1)
                    newNum= num-1;
                else if (i == 2&& num%2==0)
                    newNum=num/2;
                else if (i==3 && num%3==0)
                    newNum=num/3;


                if (!visit[newNum]){
                    arr[newNum] = arr[num]+1;
                    visit[newNum] = true;
                    q.add(newNum);
//                    System.out.println(newNum);
                }

                if (newNum ==1)
                    return;
            }
        }

    }


        }










