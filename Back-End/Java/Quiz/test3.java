public class test3 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("abcdcba"));
    }
}

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int[][] dp = new int[s.length()+1][s.length()+1];
        String reverse_s = (new StringBuffer(s)).reverse().toString();
        
        // LCS s - reverse_s
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                dp[i][j] = 0;
                if ( i>0 && j>0 && s.charAt(i-1) == reverse_s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    if (dp[i][j] > answer) answer = dp[i][j];
                }
            }
        }
    
        return answer;
    }
}