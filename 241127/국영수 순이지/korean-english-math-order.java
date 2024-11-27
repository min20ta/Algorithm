
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
            int kuk = Integer.parseInt(st.nextToken());
            int eng= Integer.parseInt(st.nextToken());
            int math= Integer.parseInt(st.nextToken());


            arr[i] = new Place(name, kuk,eng,math);
        }

        Arrays.sort(arr, new Comparator<Place>() {
            @Override
            public int compare(Place o1, Place o2) {
                if (o1.kuk == o2.kuk) {
                    if (o2.eng == o1.eng)
                        return o2.math - o1.math;
                    return o2.eng - o1.eng;
                }

                return o2.kuk-o1.kuk;
            }
        });
        for(Place a : arr)
            System.out.println(a.name+" "+a.kuk+" "+a.eng+" "+a.math);

    }
}

class Place {
    String name;
    int kuk;
    int eng;
    int math;


    Place( String name, int kuk,int eng,int math) {
        this.name = name;
        this.kuk = kuk;
        this.eng = eng;
        this.math = math;
    }
}



