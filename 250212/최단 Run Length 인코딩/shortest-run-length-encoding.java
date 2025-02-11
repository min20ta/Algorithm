
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
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();

//       arr = new int[n][m];
        LinkedList<Character > list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            list.add(c);
        }

        int index = 0;
        while(true){//하나씩 전부 이동
            if (index == str.length())
                break;

            int count = 1;
            int sum = 0;
            for (int i = 1; i < str.length(); i++) {
                if (list.get(i-1) != list.get(i)){
                    String num = count + "";
                    sum += 1+num.length();
                    count = 1;
                }else {
                    count++;
                }
            }
            //마지막
            String num = count + "";
            sum += 1+num.length();

            min = Math.min(min,sum);

            list.addFirst(list.removeLast());
            index++;
        }

        System.out.println(min);





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