import java.util.*;
import java.io.*;

public class q25 {

    public static void main(String[] args) throws IOException {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        Solution sol = new Solution();

        int[] result = sol.solution(n, stages);
        for(int i=0; i<n; i++) System.out.print(result[i] + " ");
        
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;

        int[] clear = new int[N+1];

        for(int i=0; i<N+1; i++) {
            clear[i] = 0;
        }

        for(int i=0; i<len; i++) {
            for(int j=1; j<=stages[i]; j++) {
                clear[j-1]++;
            }
        }
        
        ArrayList<StageData> record = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            StageData sd = new StageData(i, (double)(clear[i-1]-clear[i]) / (double)clear[i-1]);
            record.add(sd);
        }

        Collections.sort(record);

        for(int i=0; i<N; i++) {
            answer[i] = record.get(i).stage;
        }

        return answer;
    }
}

class StageData implements Comparable<StageData> {
    int stage;
    double rate;

    StageData(int stage, double rate){
        this.stage = stage;
        this.rate = rate;
    }

    @Override
    public int compareTo(StageData other) {
        if (other.rate == this.rate) return this.stage - other.stage;
        else if(other.rate > this.rate) return 1;
        else return -1;
    }
}