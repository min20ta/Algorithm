


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int ans = 0;
    static int [] arr;
    static boolean[] visit;
    static int[] L;
    static int[] R;
    static int size = 0;
    static int [][] tempArr;

    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int alphaSize;
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<Character> set = new HashSet<>();;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //n = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char [] c = str.toCharArray();
        //1~4수 넣어 최대값
        //우선순위 모두 같다
        arr = new int[26];

        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                set.add(c[i]);
            }
        }
        size = c.length;
        alphaSize = set.size();
        visit = new boolean[26];
        getAlpha(0,c);

        System.out.println(max);


    }

    static void getAlpha(int index, char [] c) {
        if (index == alphaSize){
            max = Math.max(max, getCal(c));
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            getAlpha(index+1,c);
            list.remove(list.size()-1);
        }
    }

    static int getCal(char [] c) {
        //알파벳에 숫자를 어떻게 주지?

        int index = 0;
        visit = new boolean[26];

        for (int i = 0; i < size; i++) { //숫자 주기
            char ch = c[i];
            if (i%2 == 0 && !visit[ch-'a']){
                visit[ch-'a'] = true;
                arr[ch-'a'] = list.get(index++);
            }
        }

        int sum = arr[c[0]-'a'];

        for (int i = 0; i < size-1; i++) {
            if (i%2 != 0) {
                char ch = c[i];

                if (ch == '+') {
                    sum += arr[c[i+1]-'a'];
                }else if (ch == '-') {
                    sum -= arr[c[i+1]-'a'];
                }else if (ch == '*') {
                    sum *= arr[c[i+1]-'a'];
                }
            }
        }
        return sum;
    }


}




