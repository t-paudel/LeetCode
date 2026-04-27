package code.arraysAndList.easy;

/*
    ======================
    PROBLEM STATEMENT
    ======================

    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.


    Example 1:

    Input: nums = [2,2,1]

    Output: 1

    Example 2:

    Input: nums = [4,1,2,1,2]

    Output: 4

    Example 3:

    Input: nums = [1]

    Output: 1


    Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.

 */

public class SingleNumber {
    void main() {
        System.out.println(4^1);
        System.out.println(5^2);
        System.out.println(7^1);
        int[] nums = new int[]{4,1,2,1,2};
        int single = singleNumber(nums);
        System.out.println("The single number is: " + single);
    }

    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int occurrence;
//        for(int num:nums) {
//            if(map.get(num) != null)
//                occurrence = map.get(num);
//            else
//                occurrence = 0;
//            map.put(num, occurrence + 1);
//        }
//
//        return map.keySet().stream().filter(key -> map.get(key) == 1).findAny().get();
//
        int result = 0;
        for(int num:nums) {
            result ^= num;
        }

        return result;
    }
}
