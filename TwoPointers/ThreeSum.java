package DSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final int target = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > target)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;

                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(numbers)); // [[-1, -1, 2], [-1, 0, 1]]
    }
}
