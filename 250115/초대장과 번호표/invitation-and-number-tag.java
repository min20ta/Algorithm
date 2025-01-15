
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());//그룹

        //n명. g그룹
        //같은 사람이 동시에 여러그룹에 속 가능
        //그룹내 모든 멤버가 정확히 일치x
        //1번사람 무조건 초대장. k-1초대되었으면 마지막 사람도 초대됨

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int [] arr = new int[num];
            int count = 0;
            int idx = 0;

            for (int j = 0; j < num; j++) {
                int people = Integer.parseInt(st.nextToken());
                if (j == 0)
                    set.add(people);
                if (set.contains(people))
                    count++;
                else
                    arr[idx++] = people;
            }

            if (count == num-1) {
                set.add(arr[0]);
            }
        }

        System.out.println(set.size());

    }
}