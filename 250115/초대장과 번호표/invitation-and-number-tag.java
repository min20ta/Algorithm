
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());//그룹

        boolean [] invited = new boolean[n];
        HashSet<Integer> [] groups = new HashSet[g];
        ArrayList<Integer> [] peopleGroups = new ArrayList[n];
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < g; i++) {
            groups[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            peopleGroups[i] = new ArrayList<>();
        }

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                int num = Integer.parseInt(st.nextToken());
                num--;
                groups[i].add(num); //그룹내 사람
                peopleGroups[num].add(i);  //사람이 포함된 모든 그룹
            }
        }

        q.add(0);
        invited[0] = true;
        while (!q.isEmpty()) { //사람한명씩 검사.
            int x = q.poll();
            ans++;

            for (int i = 0; i < peopleGroups[x].size(); i++) {
                //for문을 돌지않고 한번에
                //사람을 제거하기 위해서 hashSet사용
                int gNum = peopleGroups[x].get(i);

                groups[gNum].remove(x);

                if (groups[gNum].size() == 1){
                    int pNum = new ArrayList<>(groups[gNum]).get(0); //한명만 남은거 꺼내기위해서 리스트로 변환
                    if (!invited[pNum]) {
                        invited[pNum] = true;
                        q.add(pNum);
                    }
                }

            }
        }
        System.out.println(ans);
    }
}