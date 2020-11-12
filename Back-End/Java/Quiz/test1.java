public class test1 {
    public int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;

        int min_x, min_y, max_x, max_y;

        if (s[0] < e[0]){
            min_x = s[0];
            max_x = e[0];
        }
        else {
            min_x = e[0];
            max_x = s[0];
        }

        if (s[1] < e[1]){
            min_y = s[1];
            max_y = e[1];
        }
        else {
            min_y = e[1];
            max_y = s[1];
        }

        for(int i=0; i<location.length; i++) { 
            int x = location[i][0];
            int y = location[i][1];

            if (x <= max_x && x >= min_x) {
                if (y <= max_y && y >= min_y) answer++;
            }
        }

        return answer;
    }
}