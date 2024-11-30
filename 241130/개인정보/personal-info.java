
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Node> arr = new ArrayList<>  ();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kee = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            arr.add(new Node(name,kee,weight));
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.name.compareTo(o2.name);
                }
            });

        System.out.println("name");
            for(Node node : arr) {
                System.out.println(node.name+" "+node.kee+" "+node.weight);

            }

        Collections.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.kee-o1.kee;
            }
        });

        System.out.println();
        System.out.println("height");
        for(Node node : arr) {
            System.out.println(node.name+" "+node.kee+" "+node.weight);

        }


    }


}

class Node{
    String name;
    int kee;
    double weight;


    Node(String name,int kee, double weight) {
        this.name = name;
        this.kee = kee;
        this.weight = weight;
    }
}



