package code.arraysAndList.easy;

/*
    ======================
    PROBLEM STATEMENT
    ======================

    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
    The input is generated such that a majority element will exist in the array.


    Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

public class MajorityElement {
    void main() {
        int[] nums = new int[]{7,1,5,3,6,4};
//        int[] nums = new int[]{7,6,4,3,1};
        int majorityElement = majorityElement(nums);
        System.out.println("The majority element is: " + majorityElement);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num:nums) {
            if(count == 0)
                candidate = num;

            if(num == candidate)
                count++;
            else
                count--;
        }

        return candidate;
    }
}
