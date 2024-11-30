
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Node(name,a,b,c));
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return (o1.a+o1.b+ o1.c)-(o2.a+o2.b+ o2.c);
                }
            });

            for(Node node : arr) {
                System.out.println(node.name+" "+node.a+" "+node.b+" "+node.c+" ");

            }



    }


}

class Node{
    String name;
    int a;
    int b;
    int c;

    Node(String name,int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}



