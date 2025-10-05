package DSA.TwoPointers;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target)
                l++;
            else
                r--;
        }

        return new int[] { l, r };
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target))); // [0, 1]
    }
}
