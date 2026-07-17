package code.companies.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    static void main() {
        int[] nums = new int[] {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num : map.keySet()) {
            pq.offer(num);

            if(pq.size() > k)
                pq.poll();
        }

        for(int i=0;i<k;i++)
            result[i] = pq.poll();

        return result;
    }
}
