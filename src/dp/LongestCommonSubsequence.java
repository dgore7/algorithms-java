package dp;

/**
 * Created by dgore7 on 11/26/2016.
 */
public class LongestCommonSubsequence {
    static int[][] dp;

    public static int lcs(String first, String second) {
        dp = new int[first.length()+1][second.length()+1];
        for (int i=1; i<=first.length(); i++) {
            for (int j=1; j<= second.length(); j++) {
                if (first.charAt(i-1) == second.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[first.length()][second.length()];
    }


    public static void printLCS(String first, int len1, int len2) {
        if (dp[len1][len2] == 0)
            return;
        else if (dp[len1][len2] == dp[len1-1][len2])
            printLCS(first, len1-1, len2);
        else if (dp[len1][len2] == dp[len1][len2-1])
            printLCS(first, len1, len2-1);
        else {
            printLCS(first, len1-1, len2-1);
            System.out.println(first.charAt(len1-1));
        }

    }

    public static void main(String[] args) {
        String string1 = "ABBBVVVCCD";
        String string2 = "ADBCCVVVCDAAAAAA";
        System.out.println(lcs(string1,string2));
        printLCS(string1, string1.length(), string2.length());
    }
}
