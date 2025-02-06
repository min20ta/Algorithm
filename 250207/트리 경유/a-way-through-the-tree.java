import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int q;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[q];
        tree = new int[n + 1];  // ❗ 배열 크기 수정

        for (int i = 0; i <= n; i++) {
            tree[i] = i;  // ❗ 초기화
        }

        for (int i = 0; i < q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < q; i++) {
            int find = arr[i];  // ❗ idx 대신 직접 접근
            int parent = find / 2;
            boolean ans = true;
            int blockedNode = 0;  // ❗ 차단된 노드 저장

            while (parent > 0) {  // ❗ 수정: parent != 1 ❌ → parent > 0 ⭕
                if (tree[parent] == -1) {  // ❗ 부모가 차지되었으면
                    ans = false;
                    blockedNode = parent;  // 차단된 노드 저장
                    break;
                }
                parent /= 2;
            }

            if (ans) {
                System.out.println(0);  // 이동 가능
                tree[find] = -1;  // ❗ 노드 차지
            } else {
                System.out.println(blockedNode);  // ❗ 차단된 부모 노드 출력
            }
        }
    }
}












