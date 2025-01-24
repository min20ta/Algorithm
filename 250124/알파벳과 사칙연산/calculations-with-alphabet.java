
import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Character> intArrayList = new ArrayList<>();
    static ArrayList<Character> opArrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> alphaArrayList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i%2== 0)
                intArrayList.add(c);
            else
                opArrayList.add(c);
        }

        findMax(0);
        System.out.println(max);


    }

    static void findMax(int count) {
        if (count == 6) {
            max = Math.max(max, calc());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            alphaArrayList.add(i);
            findMax(count+1);
            alphaArrayList.remove(alphaArrayList.size()-1);
        }

    }

    static int calc() {
        int [] numArr = new int[intArrayList.size()];

        for (int i = 0; i < intArrayList.size(); i++) {
            char alpha = intArrayList.get(i);
            int num = 0;

            if (alpha == 'a') {
                num = alphaArrayList.get(0);
            }else if (alpha =='b') {
                num = alphaArrayList.get(1);
            }else if(alpha == 'c') {
                num = alphaArrayList.get(2);
            }else if (alpha == 'd') {
                num = alphaArrayList.get(3);
            }else if (alpha == 'e') {
                num = alphaArrayList.get(4);
            }else if (alpha == 'f') {
                num = alphaArrayList.get(5);
            }

            numArr[i] = num;
        }

        int sum = numArr[0];

        for (int i = 0; i < opArrayList.size(); i++) {
            char op = opArrayList.get(i);

            if (op == '+') {
                sum += numArr[i+1];
            }else if (op == '-') {
                sum -= numArr[i+1];
            }else if (op == '*') {
                sum *= numArr[i+1];
            }

        }
        return sum;
    }
}



