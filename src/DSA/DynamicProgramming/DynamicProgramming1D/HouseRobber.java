package DSA.DynamicProgramming.DynamicProgramming1D;

public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
    }
}
