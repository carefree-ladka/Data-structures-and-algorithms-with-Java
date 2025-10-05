package DSA.Backtracking;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total / 2;

        if (total % 2 != 0) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5})); // true
        System.out.println(canPartition(new int[]{1, 2, 3, 5})); // false
    }
}
