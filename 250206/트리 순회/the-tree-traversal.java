import java.util.Scanner;

public class Main {
    public static final int MAX_N = 26;
    
    // 변수 선언
    public static int n;
    public static int[] leftNum = new int[MAX_N];
    public static int[] rightNum = new int[MAX_N];
    
    public static void preOrder(int x) {
        // -1이면 존재하지 않으므로 빠져나갑니다.
        if(x == -1)
            return;
    
        System.out.print((char)(x + 'A'));
        preOrder(leftNum[x]);
        preOrder(rightNum[x]);
    }
    
    public static void inOrder(int x) {
        // -1이면 존재하지 않으므로 빠져나갑니다.
        if(x == -1)
            return;
    
        inOrder(leftNum[x]);
        System.out.print((char)(x + 'A'));
        inOrder(rightNum[x]);
    }
    
    public static void postOrder(int x) {
        // -1이면 존재하지 않으므로 빠져나갑니다.
        if(x == -1)
            return;
    
        postOrder(leftNum[x]);
        postOrder(rightNum[x]);
        System.out.print((char)(x + 'A'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        // 자식이 없는 경우 -1을 넣어줍니다.
        for(int i = 0; i < n; i++)
            leftNum[i] = rightNum[i] = -1;

        for(int i = 0; i < n; i++) {
            char x = sc.next().charAt(0);
            char l = sc.next().charAt(0);
            char r = sc.next().charAt(0);

            if(l != '.')
                leftNum[x - 'A'] = l - 'A';
            if(r != '.')
                rightNum[x - 'A'] = r - 'A';
        }

        // 전위 순회를 진행합니다.
        preOrder(0);
        System.out.println();
        // 중위 순회를 진행합니다.
        inOrder(0);
        System.out.println();
        // 후위 순회를 진행합니다.
        postOrder(0);
        System.out.println();
    }
}
