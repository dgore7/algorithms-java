package dp;

/**
 * Created by dgore7 on 11/25/2016.
 */
public class BalloonBurst {
    public int maxCoinsBottomUp(int[] nums) {
        int[][] T = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k=i; k <= j; k++) {
                    // leftVal and rightVal are initially one.
                    // if there is a value on the left or the right,
                    // they will change respectively
                    int leftVal = i == 0 ? 1 : nums[i-1];;
                    int rightVal = j == nums.length - 1 ? 1 : nums[j+1];
                    // before is initially 0, and will stay zero iff k == i
                    // else before = T[i][k-i]
                    // after is initially 0, and will stay zero iff k == j
                    // else after = T[k+1][j]
                    int before = i == k ? 0 : T[i][k-i];
                    int after = j == k ? 0 : T[k+1][j];
                    T[i][j] = Math.max(leftVal * nums[k] * rightVal + before + after, T[i][j]);
                }

            }
        }

        return T[0][nums.length-1];
    }
}
