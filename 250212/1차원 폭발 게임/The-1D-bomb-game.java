
import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int q;
    static int idx = 0;
    static int root;
    static boolean[][] visit;
    static int [] dx = new int[]{0,-1,0,1};
    static int [] dy = new int[]{1,0,-1,0};
    static int [][] arr;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();


        for (int j = 0; j < n; j++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        //동시에 터짐
    
        boolean end = false;
        while(!end && !list.isEmpty()) {
            end = true;
            List<Integer> temp = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
        
            temp.add(list.get(0));

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == list.get(i-1)){
                    temp.add(list.get(i));
                }else {
                    if(temp.size() < m) {
                        temp2.addAll(temp);
                    }else {
                        end = false;
                    }
                    temp.clear();
                    temp.add(list.get(i));
                }   
            }
            if(temp.size() < m)
                temp2.addAll(temp);
            
            list = temp2;

         
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }




}

