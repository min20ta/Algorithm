import java.util.*;
import java.io.*;

public class Main {

    static int n, m, q;
    static List<LinkedList<Integer>> list = new ArrayList<>();
    static List<LinkedList<Integer>> list2 = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // 리스트 초기화 (각 행을 LinkedList로 관리)
        for (int i = 0; i < n; i++) {
            list.add(new LinkedList<>());
            list2.add(new LinkedList<>());
        }

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        // Q번 바람 실행
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            rotateBorder(r1, c1, r2, c2); // 경계 회전
            updateInnerValues(r1, c1, r2, c2); // 내부 평균 업데이트
        }

        // 최종 결과 출력
        for (int i = 0; i < n; i++) {
            for (int num : list.get(i)) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // ✅ 직사각형 경계 회전 (시계 방향)
    static void rotateBorder(int r1, int c1, int r2, int c2) {
        LinkedList<Integer> temp = new LinkedList<>();

        // 테두리 원소 저장 (시계 방향)
        for (int j = c1; j <= c2; j++) temp.add(list.get(r1).get(j)); // 상단
        for (int i = r1 + 1; i <= r2; i++) temp.add(list.get(i).get(c2)); // 오른쪽
        for (int j = c2 - 1; j >= c1; j--) temp.add(list.get(r2).get(j)); // 하단
        for (int i = r2 - 1; i > r1; i--) temp.add(list.get(i).get(c1)); // 왼쪽

        // 회전
        temp.addFirst(temp.removeLast());

        // 회전된 값 다시 삽입
        int index = 0;
        for (int j = c1; j <= c2; j++) list.get(r1).set(j, temp.get(index++));
        for (int i = r1 + 1; i <= r2; i++) list.get(i).set(c2, temp.get(index++));
        for (int j = c2 - 1; j >= c1; j--) list.get(r2).set(j, temp.get(index++));
        for (int i = r2 - 1; i > r1; i--) list.get(i).set(c1, temp.get(index++));
    }

    // ✅ 내부 평균 업데이트
    static void updateInnerValues(int r1, int c1, int r2, int c2) {
        // list2를 list의 복사본으로 갱신
        for (int i = 0; i < n; i++) {
            list2.get(i).clear();
            list2.get(i).addAll(list.get(i));
        }

        // 내부 값 평균 계산
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = list2.get(i).get(j);
                int count = 1;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        sum += list2.get(nx).get(ny);
                        count++;
                    }
                }

                list.get(i).set(j, sum / count); // 평균 값 적용 (버림 연산)
            }
        }
    }
}
