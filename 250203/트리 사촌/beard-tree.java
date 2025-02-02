
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int k;
    static int ans = 0;
    static int root;
    static boolean[] visit;
    static int findingNode;
    static ArrayList<Integer>[] tree;
    static int[] arr;
    static int[] parentArr;
  


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        parentArr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;

            if (a == k)
                findingNode = i; //찾고자하는 노드의 인덱스
        }

        int parent = 0;
        for (int i = 2; i <=n ; i++) {
            if (arr[i-1]+1 < arr[i])
                parent++;

            parentArr[i] = parent;
        }

        for (int i = 1; i <= n; i++) {
            if(parentArr[parentArr[i]]==0 || parentArr[parentArr[findingNode]]== 0 )
                continue;

            if (parentArr[i]!= parentArr[findingNode] 
                    && parentArr[parentArr[i]] == parentArr[parentArr[findingNode]])
                ans++;
        }


        System.out.println(ans);

    }





        }




