


import java.util.*;
import java.io.*;


public class Main {


    static List<Integer> list = new ArrayList<>();
    static int type = 0;
    static int max = Integer.MIN_VALUE;
    static int [] alpha ;
    static String str;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();





        //알파벳 종류에 따른 1~4 삽입. 같아도 됨
        //1. set으로 알파벳
        //2. 배열에 [26]넣어서 a-f까지 다 채운다
        alpha = new int[6];

        findMax(0);

        System.out.println(max);

    }

    static void findMax(int depth) {

        if (depth == 6){
            max = Math.max(max, calc());
            return;
        }

        for (int i = 1; i <=4 ; i++) {
            alpha[depth] = i;
            findMax(depth+1);

        }


    }

    static int calc() {
        int len = str.length();
        int value = alpha[str.charAt(0) - 'a'];

        for (int i = 2; i < len ; i+= 2) {
            char op = str.charAt(i-1);

            if (op == '+')
                value += alpha[str.charAt(i)-'a'];
            else if (op == '-')
                value -= alpha[str.charAt(i)-'a'];
            else
                value *= alpha[str.charAt(i)-'a'];
        }

        return value;
    }


}






