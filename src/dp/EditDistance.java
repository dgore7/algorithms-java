package dp;

/**
 * Created by dgore7 on 11/27/2016.
 */
public class EditDistance {
    private static int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < z && y < x) return y;
        return z;
    }


    public static int editDist(String start, String goal) {
        int[][] dp = new int[start.length() + 1][goal.length() + 1];
        for (int i = 0; i <= start.length(); i++) {
            for (int j = 0; j <= goal.length(); j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (start.charAt(i-1) == goal.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
            }
        }
        return dp[start.length()][goal.length()];
    }

    public static void main(String[] args) {
        System.out.println(editDist("saturday", "sunday"));
    }
}
