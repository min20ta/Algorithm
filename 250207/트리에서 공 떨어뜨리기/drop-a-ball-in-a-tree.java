import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long k;
    static int[] left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        left = new int[n + 1];
        right = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
        }

        k = Long.parseLong(br.readLine());

        // 공 떨어뜨리기 시뮬레이션
        int node = 1; // 루트에서 시작
        while (true) {
            // 리프 노드에 도착하면 멈춤
            if (left[node] == -1 && right[node] == -1) {
                System.out.println(node);
                return;
            }

            if (left[node] == -1) {
                // 왼쪽 자식이 없으면 무조건 오른쪽으로 이동
                node = right[node];
            } else if (right[node] == -1) {
                // 오른쪽 자식이 없으면 무조건 왼쪽으로 이동
                node = left[node];
            } else {
                // 왼쪽과 오른쪽 자식이 모두 있는 경우
                if (k % 2 == 1) {
                    node = left[node]; // 왼쪽으로 이동
                } else {
                    node = right[node]; // 오른쪽으로 이동
                }
                k /= 2;
            }
        }
    }
}












