import java.util.*;
import java.io.*;

public class q11 {
    public static int n, k, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        // Initialize Play Map
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = 0; // Empty = 0
            }
        }
        map[0][0] = 9; // Snake = 9
        for(int i=0; i<k; i++) {
            String tmp = br.readLine();
            int idx = tmp.indexOf(' ');
            int row = Integer.parseInt(tmp.substring(0, idx));
            int col = Integer.parseInt(tmp.substring(idx+1, tmp.length()));
            map[row-1][col-1] = 1; // Apple = 1
        }

        // Initialize Rotation List
        l = Integer.parseInt(br.readLine());
        int[][] direction = new int[l][2];
        for(int i=0; i<l; i++) {
            String tmp = br.readLine();
            int idx = tmp.indexOf(' ');
            direction[i][0] = Integer.parseInt(tmp.substring(0, idx));
            direction[i][1] = tmp.charAt(idx+1) == 'L' ? 1 : 2; // 1-Left, 2-Right
        }

        // PLAYING
        int nextRotate = 0;
        int snakeDirection = 1; // 0-up, 1-right, 2-down, 3-left
        Deque<Integer> snakeBody = new ArrayDeque<>();
        snakeBody.add(0);
        snakeBody.add(0);
        int playTime = 0;

        while(true) {
            playTime++;

            // Get Head
            int[] p = new int[2];
            p[1] = snakeBody.pollLast();
            p[0] = snakeBody.getLast();
            snakeBody.add(p[1]);

            // Move Head
            switch (snakeDirection) {
                case 0:
                    p[0] -= 1;
                    break;

                case 1:
                    p[1] += 1;
                    break;

                case 2:
                    p[0] += 1;
                    break;

                case 3:
                    p[1] -= 1;
                    break;
            }

            // Check End of Game
            if(p[0] < 0 || p[0] >= n || p[1] < 0 || p[1] >= n) break; // Out of Map
            if(map[p[0]][p[1]] == 9) break; // Collision Body

            // Check Apple
            if(map[p[0]][p[1]] == 0) {
                int[] tail = new int[2];
                tail[0] = snakeBody.pollFirst(); // No apple, Delete tail
                tail[1] = snakeBody.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }

            // Move Done.
            map[p[0]][p[1]] = 9;
            snakeBody.add(p[0]);
            snakeBody.add(p[1]);

            // Check Rotate
            if (nextRotate >= 0 && playTime == direction[nextRotate][0]) {
                snakeDirection = direction[nextRotate][1] == 2 ? (snakeDirection+1) % 4 : (4+snakeDirection-1) % 4;

                if (++nextRotate == l) nextRotate = -1;
            }
        }

        System.out.println(playTime);
    }
}