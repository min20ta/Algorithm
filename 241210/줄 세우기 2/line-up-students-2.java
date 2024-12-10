
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Nodes [] arr = new Nodes[n];
       
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            arr[i] = new Nodes(w,h,i+1);
        }
       Arrays.sort(arr, new Comparator<Nodes>() {
           @Override
           public int compare(Nodes o1, Nodes o2) {
               if (o1.h == o2.h)
                   return o2.w - o1.w;
                return o1.h-o2.h;
           }
       });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].h+" "+arr[i].w+" "+arr[i].index);
        }

    }

    static class Nodes {
        int h;
        int w;
        int index;

        Nodes(int w, int h,int index) {
            this.w = w;
            this.h = h;
            this.index = index;
        }
    }
}



