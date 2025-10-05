package DSA.TwoPointers;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                max += leftMax - height[left++];
            } else {
                max += rightMax - height[right--];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(numbers)); // 6
        System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 })); // 9
    }
}
