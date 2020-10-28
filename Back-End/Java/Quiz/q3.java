import java.io.*;
import java.util.*;

public class q3 {
    public static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        char flag = s.charAt(0);
        int cnt = 0;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != flag) {
                flag = s.charAt(i);
                cnt++;
            }
        }

        System.out.println((cnt+1)/2);
    }
}