
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{0,-1,0,1};
    static int [] dy = new int[]{1,0,-1,0};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        //동시에 터짐
        while(true) {
            int count = 1;
            int start = 0;
            boolean notSame = true;

            if (list.size() == 1){
                if (m <= 1)
                    System.out.println(0);
                else{
                    System.out.println(1);
                    System.out.println(list.get(0));
                }
                System.exit(0);
            }

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) != list.get(i-1)){
                    if (count >= m) {
                        for (int j = start; j < i; j++) {
                            list.set(j,0);
                        }
                    }
                    count = 1;
                    start = i;
                }else{
                    count++;
                    notSame = false;
                }
            }

            if (notSame)
                break;

            //마지막원소 처리
            if (start != list.size()-1) {
                if (count >= m) {
                    for (int j = start; j < list.size(); j++) {
                        list.set(j, 0);
                    }
                }
            }

            //배열복사해서 옮기기
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != 0)
                    temp.add(list.get(i));
            }

            list.clear();
            list.addAll(temp);
            temp.clear();



        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static class pair{
        int x;
        int y;
        int len;


        pair(int x, int y , int len)
        {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }


}