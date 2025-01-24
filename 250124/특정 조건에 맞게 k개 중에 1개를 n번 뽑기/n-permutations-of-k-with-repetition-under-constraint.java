
import java.util.*;
import java.io.*;


public class Main {

    static int k ;
    static int n ;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        find(0);
    }

    static void find(int count) {
        if (count == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arrayList.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k ; i++) {
            if(count >= 2 &&
                    i == arrayList.get(count - 1) &&
                    i == arrayList.get(count - 2))
                continue;

                arrayList.add(i);
                find(count+1);
                arrayList.remove(arrayList.size()-1);

            }
        }
    }




