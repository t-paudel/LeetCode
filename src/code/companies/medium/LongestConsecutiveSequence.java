/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements
    sequence.

    You must write an algorithm that runs in O(n) time.

    Example 1:

    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.
    Example 2:

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
    Example 3:

    Input: nums = [1,0,1,2]
    Output: 3

    Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
 */

package code.companies.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    static void main() {
        int[] n = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(n));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int longestSequence = 0;
        for(int n : set) {
            if(!set.contains(n-1)) {
                int length = 1;
                int current = n;
                while(set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longestSequence = Math.max(length, longestSequence);
            }
        }

        return longestSequence;
    }
}
