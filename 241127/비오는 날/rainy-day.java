
import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String day = st.nextToken();
            String wa = st.nextToken();

            if (wa.equals("Rain")) {
                arr.add(new Node(date, day, wa));
            }
        }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.date.compareTo(o2.date);
                }
            });

            System.out.println(arr.get(0).date+" "+arr.get(0).day+" "+arr.get(0).weather);



    }


}

class Node{
    String date;
    String day;
    String weather;

    Node(String date,String day,String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
}



