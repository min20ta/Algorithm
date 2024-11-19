
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int idx = n-1;
        int count = 1;
        while (idx >= 0 && list.get(idx) > list.get(idx-1)) {
            idx--;
            count++;
        }
        System.out.println(n-count);
        }

    }







