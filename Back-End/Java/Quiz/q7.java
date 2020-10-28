import java.util.*;
import java.io.*;

public class q7 {
    public static String n;
    public static int left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        n = br.readLine();

        int len = n.length();
        left = 0;
        right = 0;
        
        for(int i=0; i<len; i++) {
            if (i < len/2) left += n.charAt(i) - '0';
            else right += n.charAt(i) - '0';
        }

        if (left == right) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}