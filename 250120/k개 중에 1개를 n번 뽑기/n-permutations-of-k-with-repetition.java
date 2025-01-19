
import java.util.*;
import java.io.*;


public class Main {

    static int k;
    static int n;
    static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());  //범위
        n = Integer.parseInt(st.nextToken()); //자리수
        
        num(0);
     


    }
    
    static void num(int idx) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arrayList.add(i);
            num(idx+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

}