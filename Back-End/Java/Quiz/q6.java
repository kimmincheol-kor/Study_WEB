import java.util.*;
import java.io.*;

public class q6 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(Solution.solution(food_times, k));
    }
}

class Solution {
    public static int solution(int[] food_times, long k) {
        int food_num = food_times.length;

        int pass = 0;
        for(int i=0; ; i++) {
            int food = i % food_num;
            if (food_times[food] > 0) {
                if (i-pass == k) {
                    return food+1;
                }

                food_times[food]--;
            }
            else pass++;
        }
    }
}