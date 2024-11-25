
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game[] arr = new Game[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            arr[i] = new Game(user, score);
        }

        int min = Integer.MAX_VALUE;
        int who = 0;
        for (int i = 0; i < 5; i++) {
            if (min > arr[i].score) {
                min = arr[i].score;
                who = i;
            }
        }

        System.out.println(arr[who].name + " " + min);


    }
}

class Game {
    String name;
    int score;

    Game(String name, int score) {
        this.name = name;
        this.score = score;
    }
}



