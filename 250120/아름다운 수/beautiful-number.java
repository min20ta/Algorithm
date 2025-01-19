
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static ArrayList<Integer> arrayList = new ArrayList<>();
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
            sum+=check();
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arrayList.add(i);
            num(idx+1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    static int check() {

        for (int i = 0; i < n; i+= arrayList.get(i)) {
            if (i+arrayList.get(i)-1 >= n)
                return 0;
            
            for (int j = i; j <i+arrayList.get(i) ; j++) {
                if (arrayList.get(j)!=arrayList.get(i))
                    return 0;
            }
        }
        return 1;

    }

}