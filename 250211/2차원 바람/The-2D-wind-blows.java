
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






    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

//        arr = new int[n][m];
        List<Integer> [] list = new ArrayList[n];
        List<Integer> [] list2 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
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

            for (int l = r1; l < r2; l++) {
                int temp = list[l].get(c2);
                list[l].remove(c2);
                list[l + 1].add(c2 + 1, temp);
            }

            int temp = list[r2].get(c1);
            list[r2].remove(c1);
            if (r2 == r1+1)
                list[r2 - 1].add(c1, temp);
            else
                list[r2 - 1].add(c1+1, temp);

            for (int j = r2-1; j > r1; j--) {
                temp = list[j].get(c1);
                list[j].remove(c1);
                list[j - 1].add(c1, temp);
            }

//            for (int w = 0; w < n; w++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(list[w].get(j)+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            //평균

            for (int h = 0; h < n; h++) {
                list2[h].clear();
                for (int j = 0; j < m; j++) {
                    list2[h].add(list[h].get(j));
                }
            }

            for (int p = r1; p <= r2; p++) {
                for (int j = c1; j <= c2; j++) {
                    int sum = list2[p].get(j);
                    int num = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = p + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            sum += list2[x].get(y);
                            num++;
                        }
                    }
                    int mean = sum / num;
                    list[p].set(j, mean);
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
                System.out.print(list[i].get(j)+" ");
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