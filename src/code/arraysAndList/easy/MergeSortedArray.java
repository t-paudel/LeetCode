package code.arraysAndList.easy;

/*
    ======================
    PROBLEM STATEMENT
    ======================


    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of
    elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1
    has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and
    should be ignored. nums2 has a length of n.



    Example 1:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    Example 2:

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].
    Example 3:

    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


    Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109


    Follow up: Can you come up with an algorithm that runs in O(m + n) time?

 */

import java.util.Arrays;

public class MergeSortedArray {
    void main() {
        int[] nums1 = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = new int[]{-50,-50,-48,-47,-44,-44,-37,-35,-35,-32,-32,-31,-29,-29,-28,-26,-24,-23,-23,-21,-20,-19,-17,-15,-14,-12,-12,-11,-10,-9,-8,-5,-2,-2,1,1,3,4,4,7,7,7,9,10,11,12,14,16,17,18,21,21,24,31,33,34,35,36,41,41,46,48,48};
        merge(nums1, 0, nums2, nums2.length);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        try {
            while(i>=0 && j>=0) {
                if(nums1[i] >= nums2[j])
                    nums1[k--] = nums1[i--];
                else
                    nums1[k--] = nums2[j--];
            }
            while(j>=0) {
                nums1[k--] = nums2[j--];
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
