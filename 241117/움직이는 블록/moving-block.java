import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int avg = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        avg = sum/n;

        int ans= 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > avg)
                ans+= (arr[i]-avg);
        }

        System.out.println(ans);
        
        

    }
}


