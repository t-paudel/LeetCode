package code.companies.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    static void main() {
        int[] n = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(n, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;

        for(int i=0;i<n;i++) {
            // Remove the index which is outside the window
            while(!deque.isEmpty() &&
                    deque.peekFirst() <= i-k)
                deque.pollFirst();

            // Remove all the indexes which contains smaller elements in the current window.
            while(!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.offerLast(i);
            if(i >= k - 1)
                result[idx++] = nums[deque.peekFirst()];
        }


//  This code gives O(n*k)

//        int j=0;
//        for(int i=0;i<nums.length;i++) {
//            int max=nums[i];
//            for(int x=i;x<nums.length && x < i + k;x++)
//                max=Math.max(max, nums[x]);
//            if(i <= nums.length - k) {
//                result[j] = max;
//                j++;
//            }
//        }

        return result;
    }
}
