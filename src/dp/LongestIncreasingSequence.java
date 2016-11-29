package dp;

import java.util.Arrays;

/**
 * Created by dgore7 on 11/27/2016.
 */
public class LongestIncreasingSequence {
    static int max;
    public static int LIS(int[] sequence) {
        int n = sequence.length;
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if( sequence[i] > sequence[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        for (int i=0; i<n; i++)
            max = Math.max(dp[i], max);
        return max;
    }
    public static int lis(int[] sequence) {
        
        max = 1;

        lis(sequence, sequence.length);

        return max;
    }

    private static int lis(int[] sequence, int end) {
        if (end == 1)
            return 1;
        int res, maxEndingHere = 1;

        for (int i=1; i<end; i++) {
            res = lis(sequence, i);
            if (sequence[i-1] < sequence[end-1])
                maxEndingHere = Math.max(maxEndingHere, res + 1);
        }
        max = Math.max(maxEndingHere, max);

        return maxEndingHere;
    }

    public static void main(String[] args) {
        int[] seq = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(LIS(seq));
    }
}

