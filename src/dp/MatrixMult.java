package dp;

/**
 * Created by dgore7 on 11/26/2016.
 */
public class MatrixMult {
    static int[][] cost;
    static int[][] placement;
    public static int getParenthesization(int[] dims) {
        int n = dims.length - 1;
        cost = new int[n][n];
        placement = new int[n][n];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                cost[i][j] = Integer.MAX_VALUE;
                for (int k=i; k < j; k++) {
                    int kCost = cost[i][k] + cost[k+1][j] + dims[i] * dims[k+1] * dims[j+1];
                    if (kCost < cost[i][j]) {
                        cost[i][j] = kCost;
                        placement[i][j] = k;
                    }
                }
            }
        }
        return cost[0][n-1];
    }

    public static void printOptimal() {
        boolean[] inAResult = new boolean[placement.length];
        printHelper(placement, 0, placement.length-1, inAResult);
    }

    private static void printHelper(int[][] s, int i, int j, boolean[]inAResult) {
        if (i != j) {
            printHelper(s, i, s[i][j], inAResult);
            printHelper(s, s[i][j] + 1, j, inAResult);
            String istr = inAResult[i] ? "_result " : " ";
            String jstr = inAResult[j] ? "_result " : " ";
            System.out.println("A_" + i + istr + "* A_" + j + jstr);
            inAResult[i] = true;
            inAResult[j] = true;
        }
    }

    public static void main(String[] args) {
        int[] dims = {5,3,1,4,6};
        System.out.println(getParenthesization(dims));
        printOptimal();
    }

}
