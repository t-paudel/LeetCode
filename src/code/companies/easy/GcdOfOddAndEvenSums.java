/*
    You are given an integer n. Your task is to compute the GCD (greatest common divisor) of
    two values:
        sumOdd: the sum of the smallest n positive odd numbers.
        sumEven: the sum of the smallest n positive even numbers.
    Return the GCD of sumOdd and sumEven.

    Example 1:

    Input: n = 4

    Output: 4

    Explanation:

    Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
    Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
    Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

    Example 2:

    Input: n = 5

    Output: 5

    Explanation:

    Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
    Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 = 30
    Hence, GCD(sumOdd, sumEven) = GCD(25, 30) = 5.

    Constraints:
        1 <= n <= 1000
 */
package code.companies.easy;

import java.util.stream.IntStream;

public class GcdOfOddAndEvenSums {
    static void main() {
        System.out.println(gcdOfOddEvenSums(4));
    }

    public static int gcdOfOddEvenSums(int n) {
        return n;
        /*
            EXPLANATION --
            Sum of first n odd numbers  = n^2;  (Sum of AP = n/2 * [2a + (n-1)d])
            Sum of first n even numbers = n(n+1);
            GCD(n^2, n(n+1)) => n * GCD(n, n+1)
            GCD(n, n+1) will always be 1 as these are co-prime.
            Hence, GCD = n * 1 = n
         */
    }
}
