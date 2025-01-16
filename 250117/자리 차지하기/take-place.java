
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        //의자에 1번부터 m번까지 번호
        //a: i사람은 a이하의자에만 앉는다
        //종료: 최초로 앉지 못하느느 사람 생기면 종료. 최대수
        for (int i = 1; i <= m; i++) {
            set.add(i);
        }

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (set.floor(a)!= null) {
                set.remove(set.floor(a));
                ans++;
            }else
                break;
        }

        System.out.println(ans);
    }
}