import java.util.*;
import java.io.*;

public class q26 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int answer = 0;

        for (int i=0; i<n; i++) {
            heap.add(Integer.parseInt(br.readLine()));
        }

        while(heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            answer += a+b;
            heap.add(a+b);
        }

        System.out.println(answer);
    }
}