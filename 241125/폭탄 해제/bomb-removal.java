
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            String code = st.nextToken();
            String color = st.nextToken();
            int second = Integer.parseInt(st.nextToken());

        Game a = new Game(code, color,second);


        System.out.println("code : " + a.code);
        System.out.println("color : " + a.color);
        System.out.println("second : " + a.second);


    }
}

class Game {
    String code;
    String color;
    int second;

    Game(String code, String color,int second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }
}



