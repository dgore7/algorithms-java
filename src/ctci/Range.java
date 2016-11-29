package ctci;

/**
 * Created by dgore7 on 11/28/2016.
 */
public class Range {
    public static String numbersNotInRange(int[] a) {
        boolean[] inRange = new boolean[101];
        for ( int i : a) {
            inRange[i] = true;
        }
        int iter = 0;
        StringBuilder sb = new StringBuilder();
        while (iter <= 100) {
            if (!inRange[iter]) {
                sb.append("("+iter);
                while (iter <= 100 && !inRange[iter]) iter++;
                sb.append("-");
                sb.append(iter-1);
                sb.append(")");
            }
            else {
                iter++;
            }
        }
        if (sb.charAt(sb.length()-1) != ')') {
            sb.append("-");
            sb.append(iter-1);
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{0, 1, 3, 50,75};
        System.out.println(numbersNotInRange(arr));
    }
}
