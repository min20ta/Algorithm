
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>  ();

        //거리, 번호

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Node(x,y,i+1));
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if ((Math.abs(o1.x)+Math.abs(o1.y))==(Math.abs(o2.x)+Math.abs(o2.y)))
                        return o1.num-o2.num;
                    return (Math.abs(o1.x)+Math.abs(o1.y))-(Math.abs(o2.x)+Math.abs(o2.y));
                }
            });


            for(Node node : arr) {
                System.out.println(node.num);

            }


    }


}

class Node{

    int x;
   int y;
   int num;


    Node(int x, int y, int num) {
        this.x = x;
        this.y= y;
        this.num = num;

    }
}



