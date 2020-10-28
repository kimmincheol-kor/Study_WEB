import java.io.*;
import java.util.*;

public class q2 {
    public static String s;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        result = s.charAt(0) - '0';

        for(int i=1; i<s.length(); i++) {
            int cur = s.charAt(i) - '0';
            result = result+cur > result*cur ? result+cur : result*cur;
        }

        System.out.println(result);
    }
}