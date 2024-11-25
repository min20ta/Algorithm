
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String user = st.nextToken();
        int level = Integer.parseInt(st.nextToken());

        Game a = new Game("codetree",10);
        Game b = new Game(user,level);


        System.out.println("user " + a.user + " lv "+a.level);
        System.out.println("user " + b.user + " lv "+b.level);


    }
}

class Game {
    String user ;
    int level;

    Game(String user, int level) {
        this.user = user;
        this.level = level;
    }
}


