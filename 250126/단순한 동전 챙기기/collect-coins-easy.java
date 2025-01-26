
import java.util.*;
import java.io.*;


public class Main {

    static int n ;
    static int m ;
    static pair [] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> arrList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static pair start;
    static pair end;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new pair[10];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {

                if (str.charAt(j) - '0' >= 1 && str.charAt(j) - '0' <= 9) {
                    int num = Integer.parseInt(str.charAt(j) + "");
                    arr[num] = new pair(i, j);
                    arrList.add(num);
                } else if (str.charAt(j) == 'S') {
                    start = new pair(i, j);
                } else if (str.charAt(j) == 'E') {
                    end = new pair(i, j);
                }
            }
        }

        //최소3개 동전-> end
        // 번호 증가방향
        // 수집안해도됨. 같은 위치2번이상 지나허용


        //인자사용은 특정 수의 개수 m개 필요시 편리
        Collections.sort(arrList);
        find(0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void find(int depth) {
        if (depth == arrList.size()) {
            if (arrayList.size() >= 3)
                min = Math.min(min, calc());
            return;
        }

        //증가, ox, 3개이상

               arrayList.add(arrList.get(depth));
               find(depth + 1);
               arrayList.remove(arrayList.size() - 1);
               find(depth+1);


    }

    static int calc() {

        int x = start.x;
        int y = start.y;
        int sum = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            sum+= Math.abs(x- arr[arrayList.get(i)].x) +
                    Math.abs(y- arr[arrayList.get(i)].y);

            x = arr[arrayList.get(i)].x;
            y = arr[arrayList.get(i)].y;
            //System.out.println(x+" "+y+" ");
        }

        sum+= Math.abs(end.x- x) + Math.abs(end.y- y);
        //System.out.println(sum);
        //System.out.println();

        return sum;

    }

    static class pair{
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}




