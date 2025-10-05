package DSA.PrefixSum;

public class PrefixXOR {

    public static int[] prefixXOR(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        return prefix;
    }

    public static int rangeXor(int[] prefix, int left, int right) {
        if (left == 0) return prefix[right];
        
        return prefix[right] ^ prefix[left - 1];
    }

    void main() {
        int[] nums = {3, 5, 2, 7, 9};

        int[] prefix = prefixXOR(nums);

        System.out.println("XOR(0, 2): " + rangeXor(prefix, 0, 2)); // 3^5^2 = 4
        System.out.println("XOR(1, 3): " + rangeXor(prefix, 1, 3)); // 5^2^7 = 0
        System.out.println("XOR(2, 4): " + rangeXor(prefix, 2, 4)); // 2^7^9 = 14
    }
}
