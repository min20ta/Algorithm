
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
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

        arr = new int[n][m];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (i == k && j == l)
                            continue;

                        for (int h1 = 1; h1+j<= m; h1++) {
                            for (int w1 = 1; w1+i <= n; w1++) {

                                for (int h2 = 1; h2+l <= m; h2++) {
                                    for (int w2 = 1; w2+k <= n; w2++) {
                                        sum =getSize(i, j, h1, w1,k,l,h2,w2);
                                        //System.out.println(sum+" "+i+" "+j+" "+h1+" "+ w2+ " "+ k+" "+l+ " "+ h2+" "+w2);
                                        max = Math.max(max, sum);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        System.out.println(max);

    }

    static int getSize (int x, int y, int h, int w, int x2, int y2, int h2, int w2) {
        int sum = 0;

        if  (!(x + w <= x2 || x2 + w2 <= x || y + h <= y2 || y2 + h2 <= y))
            return Integer.MIN_VALUE;


        for (int i = x; i < x+w ; i++) {
            for (int j = y; j < y + h ; j++) {
                sum+= arr[i][j];
            }
        }


        for (int i = x2; i < x2+w2 ; i++) {
            for (int j = y2; j < y2 + h2 ; j++) {
                sum+= arr[i][j];
            }
        }

        return sum;
    }
    }