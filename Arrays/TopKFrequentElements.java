package DSA.Arrays;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int i = buckets.size() - 1; i >= 0 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                result[idx++] = num;
                if (idx == k) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, target))); // [2, 7]
    }
}
