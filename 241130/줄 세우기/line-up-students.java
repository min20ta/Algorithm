
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>  ();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int kee = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Node(i+1,kee,weight));
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.kee == o2.kee){
                        return o2.weight-o1.weight;
                    }
                    if (o2.weight == o1.weight) {
                        return o1.num - o2.num;
                    }
                    return o2.kee-o1.kee;
                }
            });

            for(Node node : arr) {
                System.out.println(node.kee+" "+node.weight+" "+node.num);

            }



    }


}

class Node{
    int num;
    int kee;
    int weight;


    Node(int num,int kee, int weight) {
        this.num = num;
        this.kee = kee;
        this.weight = weight;
    }
}



