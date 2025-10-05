package DSA.DynamicProgramming.DynamicProgramming1D;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int forward = 1;
        int backward = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            forward *= nums[i];
            result = Math.max(result, forward);
            if (forward == 0)
                forward = 1;

            backward *= nums[n - i - 1];
            result = Math.max(result, backward);
            if (backward == 0)
                backward = 1;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, 2, 3, 4, 5})); // 120
        System.out.println(maxProduct(new int[]{2, 3, -2, 4})); // 6
    }
}
