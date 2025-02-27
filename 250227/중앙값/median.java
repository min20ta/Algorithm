import java.util.*;
import java.io.*;


public class Main {

    static int[][] dir;
    static int[][] dir2;
    static int time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n;
    static int m;
    static int t;
    static double max = Double.MIN_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        //홀수번째마다 중앙값출력. 오름차순

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            int [] arr = new int[m+1];
            int median = 0;
            
            for (int j = 1; j <= m; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[j] = x;
                if (j == 1){
                    median = x;
                    System.out.print(median+" ");
                    continue;
                }

             if (j % 2 == 0) {
                 if (arr[j] < median)
                     maxPQ.add(-arr[j]);
                 else
                     minPQ.add(arr[j]);
             }else {
                 int newCand;
                 if (maxPQ.size() > minPQ.size())
                     newCand = -maxPQ.poll();
                 else 
                     newCand = minPQ.poll();
                 
                 int [] nums = {median,newCand, arr[j]};
                 Arrays.sort(nums);
                 
                 maxPQ.add(-nums[0]);
                 median = nums[1];
                 minPQ.add(nums[2]);

                 System.out.print(median+" ");
             }}
             System.out.println();
            }
       
        }



    }





