import java.io.*;
import java.util.*;

public class q1 {
    public static int [] arr;
    public static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // User Input : N
        n = Integer.parseInt(br.readLine());

        // User Input : Datas
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Sort
        Arrays.sort(arr);

        // Count Number of Group
        int cnt = 0;
        result = 0;
        for(int data: arr) {
            cnt++;

            if (cnt == data) {
                cnt = 0;
                result++;
            }
        }

        // Result
        System.out.println(result);
    }
}