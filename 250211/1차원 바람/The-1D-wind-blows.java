
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{-1,-1,1,1};
    static int [] dy = new int[]{1,-1,-1,1};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;






    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

//        arr = new int[n][m];
        List<Integer> [] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
            }
        }

        int [] rArr = new int[q];
        char [] dArr = new char[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            rArr[i] = r-1;
            dArr[i] = d;
        }


        for (int i = 0; i < q; i++) {
            int r = rArr[i];
            char d = dArr[i];

            if (d == 'L'){
                int temp = list[r].get(m-1);
                list[r].remove(m-1);
                list[r].add(0,temp);
            }else {
                int temp = list[r].get(0);
                list[r].remove(0);
                list[r].add(temp);
            }

            int up = r-1;
            int down = r+1;
            char upd = d;
            char downd = d;

            while (true) { //전파
//                System.out.println("check  "+up+" "+down);
                if (up < 0 && down >= n)
                    break;

                if (up >= 0) {
                    boolean same = false;
                    for (int j = 0; j < m; j++) {
                        if (list[up].get(j) == list[up+1].get(j)){
                            //d반대로 이동
                            same = true;
                            if (upd == 'L') {
                                int temp = list[up].get(0);
                                list[up].remove(0);
                                list[up].add(temp);
                                upd = 'R';
                            }else {
                                int temp = list[up].get(m-1);
                                list[up].remove(m-1);
                                list[up].add(0,temp);
                                upd = 'L';
                            }
                            break;
                        }
                    }
                    up--;
                    if (!same)
                        up = -1;
                }
                if (down < n) {
                    boolean same = false;
                    for (int j = 0; j < m; j++) {
                        if (list[down].get(j) == list[down-1].get(j)){
                            //d반대로 이동
                            same = true;
                            if (downd == 'L') {
                                int temp = list[down].get(0);
                                list[down].remove(0);
                                list[down].add(temp);
                                downd = 'R';
                            }else {
                                int temp = list[down].get(m-1);
                                list[down].remove(m-1);
                                list[down].add(0,temp);
                                downd = 'L';
                            }
                            break;
                        }
                    }
                    down++;
                    if (!same)
                        down = n;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println();
        }




    }


    }