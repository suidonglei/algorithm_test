package learn.algorithm.recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * possible solution:
 * 0.函数
 * 1.暴力
 * 2.divide conquer
 *
 */
public class PowXn {
    public static double myPow(double x, int n) {
        double returnValue = 1d;
        if(n == 0) return returnValue;
        if(n > 0) {
            for(int i = 1; i < n; i ++) {
                returnValue *= x;
            }
        } else {
            for(int i = 1; i < -n; i ++) {
                returnValue *= 1/x;
            }
        }
        return returnValue;

    }


    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        int i = 1;
        System.out.println(i/2);
    }
}
class Divide{
    /**
     * divide
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0.0 || x == 1.0) return x;
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n > 0) {
            if(n % 2  == 0) {
                double result = myPow(x, n/2);
                return result * result;
            } else {
                double result = myPow(x, n/2);
                return x * result * result;
            }
        } else {
            // special case for MIN_VALUE since -MIN_VALUE = MAX_VALUE+1
            if (n == Integer.MIN_VALUE)
                return myPow(x, n+1)/x;
            else
                return 1.0/myPow(x, -n);
        }
    }
}
