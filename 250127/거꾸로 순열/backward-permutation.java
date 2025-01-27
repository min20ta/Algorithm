
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean [] visit;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];

        find(0);
    }

    static void find(int depth) {

        if (depth == n){
            for (int i = 0; i < n; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for (int i = n; i >= 1 ; i--) {
            if (!visit[i]) {
                visit[i] = true;
                arrayList.add(i);
                find(depth+1);
                arrayList.remove(arrayList.size()-1);
                visit[i] = false;
            }
        }
    }
        }









