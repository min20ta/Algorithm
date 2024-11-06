import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i= 0 ; i <= 10 ; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        int answer = 0;
        for (int i = 1 ; i <= 10 ; i++) {
            for (int j = 1 ; j < list.get(i).size() ; j++) {
                if(list.get(i).get(j) != list.get(i).get(j-1))
                    answer++;
            }
        }
        System.out.println(answer);



    }
    }