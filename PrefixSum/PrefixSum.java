package DSA.PrefixSum;

public class PrefixSum {

    public static int[] prefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    public static int rangeSum(int[] prefix, int low, int high) {
        if (low == 0) return prefix[high];
        return prefix[high] - prefix[low - 1];
    }

    void main() {
        int[] nums = {2, 4, 6, 8, 10};

        int[] prefix = prefixSum(nums);

        System.out.println("Sum(0, 2): " + rangeSum(prefix, 0, 2)); // 2+4+6 = 12
        System.out.println("Sum(1, 3): " + rangeSum(prefix, 1, 3)); // 4+6+8 = 18
        System.out.println("Sum(2, 4): " + rangeSum(prefix, 2, 4)); // 6+8+10 = 24
    }
}
