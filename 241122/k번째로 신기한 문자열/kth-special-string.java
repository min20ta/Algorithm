
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String t = st.nextToken();

        String [] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        String [] arr2 = new String[n];
        ArrayList<String> list = new ArrayList<>();

        int idx = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i].startsWith(t)){
                list.add(arr[i]);
                idx++;
            }
        }

        Collections.sort(list);

        System.out.println(list.get(k-1));



    }
}



