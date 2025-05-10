


import java.util.*;
import java.io.*;


public class Main {


    static int[][] parent;
    static int[] val;
    static int[] depth;
    static boolean didBomb;
    static int time = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int n;
    static int m;
    static int k ;
    static int [][] arr;
    static int [] distance;
    static boolean[] visit;
    static int[] L;
    static int[] R;


    static int max = Integer.MIN_VALUE;
    static int maxVal = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int alphaSize;
    static ArrayList<Integer> list = new ArrayList<>();
    static PriorityQueue<Element> pq = new PriorityQueue<Element>();
    static ArrayList<Node> [] graph;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        distance = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,w));
            graph[b].add(new Node(a,w));
        }

        for (int i = 1; i <= n ; i++) {
            distance[i] = (int)1e9;
        }

        distance[k] = 0;
        pq.add(new Element(0,k));

        while (!pq.isEmpty()) {
            Element e = pq.poll();
             int minDistance = e.distance;
             int minIndex = e.index;

             if (minDistance != distance[minIndex])
                 continue;

            for (int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDistance= graph[minIndex].get(i).distance;

                int newDistance = distance[minIndex] + targetDistance;
                if (distance[targetIndex] > newDistance){
                    distance[targetIndex] = newDistance;
                    pq.add(new Element(newDistance, targetIndex));
                }


            }
        }

        for (int i = 1; i <= n ; i++) {
            if(distance[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(distance[i]);
        }
    }
    static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }


    static class Element implements Comparable<Element>{
        int distance;
        int index;

        Element(int distance, int index) {
            this.distance = distance;
            this.index = index;
        }

        @Override
        public int compareTo(Element e) {
            return this.distance - e.distance;
        }
    }




}




