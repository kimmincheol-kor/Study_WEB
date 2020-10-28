import java.util.*;
import java.io.*;

public class q8 {
    public static String s;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        s = br.readLine();
        
        ArrayList<Character> arr = new ArrayList<Character>();
        sum = 0;

        for(int i=0; i<s.length(); i++) { 
            char curCh = s.charAt(i);
            if (curCh <= '9' && curCh >= '0') {
                sum += curCh - '0';
            }
            else {
                arr.add(curCh);
            }
        }

        Collections.sort(arr);

        String result = "";
        for(char ch: arr) {
            result += ch;
        }
        result += Integer.toString(sum);

        System.out.println(result);
    }
}