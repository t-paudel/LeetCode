package arraysAndList.easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


/*
    ======================
    PROBLEM STATEMENT
    ======================

    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it
    would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104

 */

public class SearchInsertPosition {
    void main() {
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[]{1,3,5,6};
        int size = searchInsertPosition(nums, 4);
        System.out.println("Insert Location: " + size);
        System.out.println(Arrays.toString(nums));

    }
    public static int searchInsertPosition(int [] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low<=high) {
            mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
