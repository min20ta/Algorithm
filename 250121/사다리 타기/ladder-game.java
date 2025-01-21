
import java.util.*;
import java.io.*;


public class Main {


    static int n;
    static int m;
    static ArrayList<pair> lines = new ArrayList<>();
    static ArrayList<pair> selectedLines = new ArrayList<>();
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             lines.add(new pair(a-1,b));
        }

        Collections.sort(lines);

        findMinLines(0);

        System.out.println(min);



    }

    static void findMinLines(int count) {
        if (count == m){
            if (possible())
                min = Math.min(min, selectedLines.size());

            return;
        }

        selectedLines.add(lines.get(count));
        findMinLines(count+1);
        selectedLines.remove(selectedLines.size()-1);
        findMinLines(count+1);

    }

    static boolean possible() {
        int [] numArr1 = new int[n];
        int [] numArr2 = new int[n];

        for (int i = 0; i < n; i++) {
            numArr1[i] = i;
            numArr2[i] = i;
        }

        for (int i = 0; i < lines.size(); i++) {
            int index  = lines.get(i).line;
            int temp = numArr1[index];
            numArr1[index] = numArr1[index+1];
            numArr1[index+1] = temp;
        }

        for (int i = 0; i < selectedLines.size(); i++) {
            int index  = selectedLines.get(i).line;
            int temp = numArr2[index];
            numArr2[index] = numArr2[index+1];
            numArr2[index+1] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (numArr1[i] != numArr2[i])
                return false;
        }

        return true;
    }




    static class pair implements Comparable<pair>{
        int line;
        int col;

        pair(int line, int col){
            this.line = line;
            this.col = col;
        }

        @Override
        public int compareTo(pair p) {
            if (this.col == p.col)
                return this.line-p.line;
            return this.col - p.col;

        }
    }

}