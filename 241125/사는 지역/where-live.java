
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Place [] arr = new Place[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name= st.nextToken();
            String addr = st.nextToken();
            String city = st.nextToken();

            arr[i] = new Place(name ,addr, city);
        }

        Arrays.sort(arr, new Comparator<Place>() {
            @Override
            public int compare(Place o1, Place o2) {
                return o1.name.compareTo(o2.name);
            }
        });


            System.out.println("name " + arr[n-1].name );
            System.out.println("addr " + arr[n-1].addr);
            System.out.println("city " +arr[n-1].city );


    }
}

class Place {
    String name;
    String addr;
    String city;


    Place( String name, String addr,String city) {
        this.name = name;
        this.addr = addr;
        this.city =city;
    }
}



