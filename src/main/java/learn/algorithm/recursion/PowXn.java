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

    /**
     * divide
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if(n == 0) return 1.0;
        if(n > 0) {
            return calculate(x, n);
        } else {
            return calculate(1/x, -n);
        }
    }
    private static double calculate(double x, int n) {
        if(n==1) return x;
        if(n==0) return x;
        if(n % 2 == 1) {
            return x* calculate(x*x,n/2) ;
        } else {
            return calculate(x*x,n/2) ;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2, 10));
        int i = 1;
        System.out.println(i/2);
    }
}
