/*
    You are given an integer array nums of length n.

    Construct an array prefixGcd where for each index i:

    Let mxi = max(nums[0], nums[1], ..., nums[i]).
    prefixGcd[i] = gcd(nums[i], mxi).
    After constructing prefixGcd:

    Sort prefixGcd in non-decreasing order.
    Form pairs by taking the smallest unpaired element and the largest unpaired element.
    Repeat this process until no more pairs can be formed.
    For each formed pair, compute the gcd of the two elements.
    If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
    Return an integer denoting the sum of the GCD values of all formed pairs.

    The term gcd(a, b) denotes the greatest common divisor of a and b.


    Example 1:

    Input: nums = [2,6,4]

    Output: 2

    Explanation:

    Construct prefixGcd:

    i	nums[i]	mxi	prefixGcd[i]
    0	2	2	2
    1	6	6	6
    2	4	6	2
    prefixGcd = [2, 6, 2]. After sorting, it forms [2, 2, 6].

    Pair the smallest and largest elements: gcd(2, 6) = 2. The remaining middle element 2 is ignored.
    Thus, the sum is 2.
 */
package code.companies.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GcdSumOfFormedPairs {
    static void main() {
        int[] nums = new int[] {2, 6, 4};

        System.out.println(gcdSum(nums));
    }

    public static long gcdSum(int[] nums) {
        long gcdSum = 0;
        int[] prefixGcd = new int[nums.length];
        int max = nums[0];

        for(int i=0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = calculateGcd(nums[i], max);
        }
        int left = 0;
        int right = prefixGcd.length - 1;

        Arrays.sort(prefixGcd);
        while(left < right) {
            gcdSum += calculateGcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return gcdSum;
    }

    public static int calculateGcd(int n1, int n2) {
        while(n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
