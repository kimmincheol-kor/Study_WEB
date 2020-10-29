class Solution {
    public static int needs; // Number of zero in Lock

    public static boolean checkSolve(int i, int j, int[][] key, int [][] lock) {
        int solve = 0;
        for (int a=0; a<key.length; a++) {
            for (int b=0; b<key.length; b++) {
                if (i+a >= key.length-1 && i+a < lock.length-(key.length-1) && j+b >= key.length-1 && j+b < lock.length-(key.length-1)) { // Real Lock Space
                    if(lock[i+a][j+b] == 0 && key[a][b] == 1) solve++;              // Solve
                    else if (lock[i+a][j+b] == 1 && key[a][b] == 1) return false;   // Collision
                }
            }
        }
        return (solve == needs);
    }

    public boolean solution(int[][] key, int[][] lock) {
        needs = 0;
        int m = key.length;
        int n = lock.length;
        int extend = n+(2*(m-1));

        // Create Extended Lock
        int[][] extended_lock = new int[extend][extend];
        for(int i=0; i<extend; i++) {
            for (int j=0; j<extend; j++) {
                extended_lock[i][j] = 0;
                if(i >= (m-1) && j >= (m-1) && i <= m+n-2 && j <= m+n-2) {
                    if (lock[i-(m-1)][j-(m-1)] == 1) extended_lock[i][j] = 1;
                    else needs++;
                }
            }
        }

        // Create Rotated Key
        int[][][] r_key = new int[4][m][m];
        for (int i=0; i<m; i++) { // r=0
            for (int j=0; j<m; j++){
                r_key[0][i][j] = key[i][j];
            }
        }
        for (int r=1; r<4; r++) { // r=1,2,3
            for (int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    r_key[r][i][j] = r_key[r-1][m-1-j][i];
                }
            }
        }

        // Check Solvable or Not
        for (int i=0; i<m+n-1; i++) { // Move Row
            for (int j=0; j<m+n-1; j++) { // Move Col
                for (int r=0; r<4; r++) {  // Rotate
                    if (checkSolve(i, j, r_key[r], extended_lock)) return true;
                }
            }
        }

        return false;
    }
}

public class q10 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(sol.solution(key, lock));
    }
}