
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            String product= st.nextToken();
            int code = Integer.parseInt(st.nextToken());

            Game a = new Game();
            a.product = "codetree";
            a.code = 50;
            Game b = new Game( product,code);


            System.out.println("product " + a.code +" is "+a.product);
            System.out.println("product " + b.code +" is "+b.product);


    }
}

class Game {
    String product;
    int code;

    Game() {
        product = "";
        code = 0;
    }
    Game(String product, int code) {
        this.code = code;
        this.product = product;
    }
}



