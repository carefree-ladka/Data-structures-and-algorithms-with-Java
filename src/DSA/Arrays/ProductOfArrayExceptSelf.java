package DSA.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left = 1;
        int right = 1;

        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result)); // [24, 12, 8, 6]
    }
}
