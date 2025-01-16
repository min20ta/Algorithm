
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {

            TreeSet<Integer> set = new TreeSet<>();
            int k= Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    set.add(num);
                } else if (str.equals("D")) {
                    if (set.isEmpty())
                        continue;

                    if (num == 1) {
                        set.remove(set.last());
                    } else if (num == -1) {
                        set.remove(set.first());
                    }
                }

            }
            if (set.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(set.last()+" "+set.first());

        }

    }
}