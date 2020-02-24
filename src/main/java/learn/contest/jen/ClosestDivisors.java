package learn.contest.jen;

import java.util.Arrays;

/**
 * 5171. Closest Divisors
 *
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.
 *
 * Return the two integers in any order.
 */
public class ClosestDivisors {
    public static void main(String[] args) {
        ClosestDivisors closestDivisors = new ClosestDivisors();
        closestDivisors.closestDivisors(8);
    }
    public int[] closestDivisors(int num) {
        int[] v1 = calculateClosestFactors(num+1);
        int[] v2 = calculateClosestFactors(num+2);
        return v1[1]-v2[0] < v2[1]-v2[0] ? v1 : v2;
    }

    private int[] calculateClosestFactors(int num) {
        int sqrt = (int) (Math.sqrt(num));
        for (int v1 = sqrt; v1 >= 1; v1--) {
            int v2 = num / v1;
            if (num % v1 == 0) {
                return new int[]{v1, v2};
            }
        }
        return new int[]{0, Integer.MAX_VALUE};
    }
}
