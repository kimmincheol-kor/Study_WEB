class Solution
{
    public int solution(String s)
    {
        int checkLength = s.length();

        for ( ; checkLength > 1; checkLength--) {
            int halfLength = checkLength / 2;

            for(int i=0; i+halfLength*2<s.length(); i++) {
                String a = s.substring(i, i+checkLength);
                if (checker(a)) {
                    return checkLength;
                }
            }
        }

        return 1;
    }

    public boolean checker(String a) {
        int len = a.length();

        for(int i=0; i<len/2; i++) {
            if (a.charAt(i) != a.charAt(len-1-i)) return false;
        }
        return true;
    }
}