
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        ArrayList<Nodes> list = new ArrayList<Nodes>();
        int [] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int first = i;
            list.add(new Nodes(num,0,first));
            arr[i] = num;
        }


        Collections.sort(list, new Comparator<Nodes> (){
            @Override
                    public int compare(Nodes o1, Nodes o2) {
                    if (o1.num == o2.num) {
                        return o1.first-o2.first;
                    }
                    return o1.num - o2.num;
            }
        });

        for (int i = 0 ; i < n ; i++) {
           list.get(i).index = i;
        }

        //오름차순 여기가 안
      
        Collections.sort(list, new Comparator<Nodes>() {
            @Override
            public int compare(Nodes o1, Nodes o2) {
                return o1.first - o2.first;
            }
        });

        //
        for (int i = 0; i < n; i++) {
            System.out.print(((list.get(i).index)+1)+" ");
        }
    }
   
    static class Nodes {
        int num;
        int first;
        int index;

        Nodes(int num, int index,int first) {
            this.num = num;
            this.index = index;
            this.first = first;
        }
    }
}



