
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{0,1,0,-1};
    static int [] dy = new int[]{1,0,-1,0};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;



//행,열 밀기

    //행여러개 섞일때
        //2차배열
        //linkedlist addFirst, removeLast사용 로 배열 저장
            // 새로운 linkedlist에 밀어야 하는거 한번에 다시 넣기



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

//       arr = new int[n][m];
        List<LinkedList<Integer>> list = new ArrayList<>();
        List<LinkedList<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());
            list2.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(i).add(num);
            }
        }

        pair [] wind = new pair[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            wind[i] = new pair(r1,c1,r2,c2);
        }

        int r1 = 0; int r2 = 0; int c1 = 0; int c2 = 0;
         //회전
        for (int i = 0; i < q; i++) {
            r1 = wind[i].r1;
            c1 = wind[i].c1;
            r2 = wind[i].r2;
            c2 = wind[i].c2;

            r1--;
            c1--;
            r2--;
            c2--;

            LinkedList<Integer> temp = new LinkedList<>();

            for (int j = c1; j <= c2 ; j++)
                temp.add(list.get(r1).get(j));
            for (int x = r1+1; x <= r2 ; x++)
                temp.add(list.get(x).get(c2));
            for (int j = c2-1; j >= c1 ; j--)
                temp.add(list.get(r2).get(j));
            for (int x = r2-1; x > r1 ; x--)
                temp.add(list.get(x).get(c1));


            temp.addFirst(temp.removeLast());

            int index = 0;
            for (int j = c1; j <= c2 ; j++)
                list.get(r1).set(j,temp.get(index++));
            for (int x = r1+1; x <= r2 ; x++)
                list.get(x).set(c2,temp.get(index++));
            for (int j = c2-1; j >= c1 ; j--)
                list.get(r2).set(j,temp.get(index++));
            for (int x = r2-1; x > r1 ; x--)
                list.get(x).set(c1,temp.get(index++));



            //평균

            for (int h = 0; h < n; h++) {
                list2.get(h).clear();
                list2.get(h).addAll(list.get(h)); //깊은복사
            }

            for (int p = r1; p <= r2; p++) {
                for (int j = c1; j <= c2; j++) {
                    int sum = list2.get(p).get(j);
                    int num = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = p + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            sum += list2.get(x).get(y);
                            num++;
                        }
                    }
                    int mean = sum / num;
                    list.get(p).set(j, mean);
                }
            }
//
//            for (int w = 0; w < n; w++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(list[w].get(j)+" ");
//                }
//                System.out.println();
//            }

        }


//        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }




    }

    static class pair{
        int r1;
        int c1;
        int r2;
        int c2;

        pair(int r1, int c1, int r2, int c2)
        {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }


    }