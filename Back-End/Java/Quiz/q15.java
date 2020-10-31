import java.util.*;
import java.io.*;

public class q15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        // Input
        String temp = br.readLine();
        StringTokenizer stk = new StringTokenizer(temp);

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());

        boolean[][] adjList = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                adjList[i][j] = false;
            }
        }

        for(int i=0; i<m; i++) {
            String newLine = br.readLine();
            int idx = newLine.indexOf(' ');
            int a = Integer.parseInt(newLine.substring(0, idx));
            int b = Integer.parseInt(newLine.substring(idx+1, newLine.length()));
            adjList[a][b] = true;
        }
        // End of Input

        // Operation
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = true;
        for(int cnt=0; cnt<k; cnt++) {
            int siz = queue.size();
            
            for(int z=0; z<siz; z++) {
                int node = queue.poll();
                for(int q=1; q<n+1; q++) {
                    if (visited[q] == false && adjList[node][q] == true) {
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }
        // End of Operation

        // Result
        ArrayList list = new ArrayList(queue);
        Collections.sort(list);
        System.out.println(list);
    }
}