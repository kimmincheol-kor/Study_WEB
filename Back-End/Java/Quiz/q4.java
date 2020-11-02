import java.util.*;
import java.io.*;

public class q4 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Get N
        n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        // Get Coins
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(coins);

        // Operation
        int checkNum = 1;
        for (int coin:coins) {
            if (checkNum < coin) {
                System.out.println(checkNum);
                return;
            }
            else {
                checkNum += coin;
            }
        }
    }
}