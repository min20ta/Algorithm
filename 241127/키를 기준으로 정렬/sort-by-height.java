
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Place [] arr = new Place[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kee = Integer.parseInt(st.nextToken());
            String weight = st.nextToken();

            arr[i] = new Place(name, kee, weight);
        }

        Arrays.sort(arr,(a,b)-> a.kee - b.kee);
        for(Place a : arr)
            System.out.println(a.name+" "+a.kee+" "+a.weight);

    }
}

class Place {
    String name;
    int kee;
    String weight;


    Place( String name, int kee,String weight) {
        this.name = name;
        this.kee = kee;
        this.weight =weight;
    }
}
