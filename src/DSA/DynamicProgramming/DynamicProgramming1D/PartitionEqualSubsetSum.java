package DSA.DynamicProgramming.DynamicProgramming1D;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i : nums) sum += i;

        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i - j];
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4, 5})); // false
        System.out.println(canPartition(new int[]{1, 5, 11, 5})); // true
    }
}
