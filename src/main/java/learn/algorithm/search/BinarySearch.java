package learn.algorithm.search;

public class BinarySearch {

    /**
     * 69
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     *
     * @param x
     * @return
     */
    int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int left = 0;
        int right = x;
        while(left <= right) {
            // mid = (left + right) / 2 can overflow if right > Integer.MAX_VALUE - left
            int mid = left + (right - left) / 2;
            // same thing here , mid * mid > x can overflow. replace by mid > x / mid
            if(mid == x/mid) return mid;
            if(mid < x/mid) {
                left = mid + 1;
                if (left > x/left) {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
