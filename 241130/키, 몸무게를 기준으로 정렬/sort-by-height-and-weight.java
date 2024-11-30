
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>  ();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kee = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Node(name,kee,weight));
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.kee==o2.kee)
                        return o2.weight-o1.weight;
                    return o1.kee-o2.kee;
                }
            });


            for(Node node : arr) {
                System.out.println(node.name+" "+node.kee+" "+node.weight);

            }


    }


}

class Node{
    String name;
    int kee;
   int weight;


    Node(String name,int kee, int weight) {
        this.name = name;
        this.kee = kee;
        this.weight = weight;
    }
}



