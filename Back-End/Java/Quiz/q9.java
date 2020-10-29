class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for(int unit=1; unit<(len/2)+1; unit++) {
            int cnt = 0;
            int result = 0;
            String flag = s.substring(0, unit);

            for(int j=unit; j+unit-1<len; j+=unit) {
                if(flag.equals(s.substring(j, j+unit))) { 
                    cnt++;
                }
                else {
                    flag = s.substring(j, j+unit);
                    if(cnt > 0) {
                        int e = 1;
                        if (cnt >= 10) e++;
                        if (cnt >= 100) e++;
                        if (cnt >= 1000) e++;
                        result += (cnt*unit)-e;
                        cnt = 0;
                    }
                }
            }

            if(cnt > 0) {
                int e = 1;
                if (cnt >= 10) e++;
                if (cnt >= 100) e++;
                if (cnt >= 1000) e++;
                result += (cnt*unit)-e;
            }

            if(result > answer) answer = result;
        }

        return len-answer;
    }
}

public class q9 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "aabbaccc";
        System.out.println(sol.solution(s));

        s = "ababcdcdababcdcd";
        System.out.println(sol.solution(s));

        s = "abcabcdede";
        System.out.println(sol.solution(s));

        s = "abcabcabcabcdededededede";
        System.out.println(sol.solution(s));

        s = "xababcdcdababcdcd";
        System.out.println(sol.solution(s));
    }
}