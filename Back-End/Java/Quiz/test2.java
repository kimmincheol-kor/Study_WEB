class Solution {
    public long solution(int n, int r, int c) {
        int findLine = (r-1) + (c-1) + 1;
        long start=1;
        long idx=0;
        if (findLine <= n) {
            for(int i=1; i<findLine; i++) {
                start+=i;
            }
            if(findLine % 2 == 0) {
                idx = r;
            }
            else {
                idx = c;
            }
        }
        else {
            for(int i=1; i<=n; i++) {
                start+=i;
            }
            for(int i=1; i<findLine-n; i++) {
                start+=(n-i);
            }
            if(findLine % 2 == 0) {
                idx = r-(findLine-n);
            }
            else {
                idx = c-(findLine-n);
            }
        }

        return start+idx-1;
    }
}