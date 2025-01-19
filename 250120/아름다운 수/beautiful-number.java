
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static ArrayList<String> arrayList = new ArrayList<>();
    static int sum = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //자리수
        
        num(0);

        System.out.println(sum);



    }
    
    static void num(int idx) {
        if (idx == n) {
            if (idx != 1) {
            String str = "" ;
            for (String a : arrayList){
                str += a;
            }

            sum+=check(str);}
            else if (idx == 1)
                sum = 1;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arrayList.add(i+"");
            num(idx+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    static int check(String str) {

        int count = 0;
        int start = 0;
        boolean flag = true;

        for (int i = 0; i < n-1; i++) {

            if (str.charAt(i) != str.charAt(i+1)) {
                count = i-start+1;
                if (count % str.charAt(i) != 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            return 1;
        else
            return 0;

    }

}