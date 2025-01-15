
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
        set.add(1);

        ArrayList<ArrayList<Integer>> arrlist = new ArrayList<>();

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arrlist.add(new ArrayList<>());

            for (int j = 0; j < num; j++) {
                int people = Integer.parseInt(st.nextToken());
                arrlist.get(i).add(people);
            }
            Collections.sort(arrlist.get(i));
        }

        Collections.sort(arrlist, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size() == o2.size()) {
                    return o1.get(0) - o2.get(0);
                }
                return o1.size() - o2.size();
            }
        });

        for (int i = 0; i < g; i++) {

            int num = arrlist.get(i).size();
            int [] arr = new int[num];
            int count = 0;
            int idx = 0;

            for (int j = 0; j < num; j++) {
                int people = arrlist.get(i).get(j);
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


        //1,7,11,18,5,4,9,12,13,3,20,19,6
        //1,7,11,18,5,4,12,13,9,3,20,6,19,

    }
}