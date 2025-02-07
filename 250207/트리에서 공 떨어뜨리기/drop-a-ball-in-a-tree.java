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

        int node = 1; // 루트 노드에서 시작

        while (true) {
            // 리프 노드에 도착하면 멈춘다.
            if (left[node] == -1 && right[node] == -1) {
                break;
            }

            // 왼쪽 서브트리로 이동할 경우
            if (k % 2 == 1) { 
                if (left[node] != -1) {
                    node = left[node]; 
                } else {
                    node = right[node]; // 왼쪽이 없으면 오른쪽으로 이동
                }
            }
            // 오른쪽 서브트리로 이동할 경우
            else { 
                if (right[node] != -1) {
                    node = right[node];
                } else {
                    node = left[node]; // 오른쪽이 없으면 왼쪽으로 이동
                }
            }

            k /= 2; // k를 2로 나눠서 다음 공의 이동 방향 결정
        }

        System.out.println(node);
    }
}
