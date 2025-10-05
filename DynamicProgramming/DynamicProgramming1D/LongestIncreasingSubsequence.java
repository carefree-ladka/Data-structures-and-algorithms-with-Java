package DSA.DynamicProgramming.DynamicProgramming1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) i = -(i + 1); // insertion point

            if (i == sub.size()) {
                sub.add(num);  // extend subsequence
            } else {
                sub.set(i, num); // replace with smaller value
            }
        }
        return sub.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(lengthOfLIS(new int[]{2, 3, -2, 4})); // 3
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7})); // 1
    }
}
