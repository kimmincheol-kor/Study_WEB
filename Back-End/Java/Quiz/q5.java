import java.util.*;
import java.io.*;

public class q5 {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // User Input : N, M
        String temp = br.readLine();
        int idx = temp.indexOf(' ');
        n = Integer.parseInt(temp.substring(0, idx));
        m = Integer.parseInt(temp.substring(idx+1, temp.length()));

        // Initialize
        int[] count = new int[m+1];
        int result = (n * (n-1)) / 2;
        for(int i=1; i<m+1; i++) {
            count[i] = 0;
        }

        // User Input : Balls List
        String temp2 = br.readLine();
        StringTokenizer stk = new StringTokenizer(temp2);
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(stk.nextToken());

            // Operation
            if (count[val] == 0 ) count[val] = 1;
            else result -= 1;
        }

        System.out.println(result);
    }
}