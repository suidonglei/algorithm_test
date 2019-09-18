package learn.algorithm.bitwise;

/**
 *
 *
 *
 */
public class NumberOfOneBit {

    /**
     * 191
     *  * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != (n & (n-1))){
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

    /**
     * 231. Power of Two
     *
     * Given an integer, write a function to determine if it is a power of two.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE) return false;
        return (n & (n - 1)) == 0;
    }

    /**
     * 338. Counting Bits
     * Given a non negative integer number num.
     * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] returnInt = new int[num + 1];
        for(int i = 0; i <= num; i ++) {
            if(i == 0) returnInt[i] = 0;
            else
                returnInt[i] = returnInt[i & (i - 1)] + 1;
        }
        return returnInt;
    }

}
