
import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String secretCode = st.nextToken();
        String meetingPoint = st.nextToken();
        int time = Integer.parseInt(st.nextToken());

        spy a = new spy(secretCode,meetingPoint,time);

        System.out.println("secret code : " + a.secretCode);
        System.out.println("meeting point : " + a.meetingPoint);
        System.out.println("time : " + a.time);



    }
}

class spy {
    String secretCode ;
    String meetingPoint;
    int time;

    spy( String secretCode,String meetingPoint,int time) {
        this.secretCode = secretCode;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }
}


