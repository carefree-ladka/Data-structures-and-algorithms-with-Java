package DSA.QuickSelect;

import static DSA.utils.DSAUtils.swap;

public class KthLargest {

    // Hoare partition
    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l - 1;
        int j = r + 1;

        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j) return j;

            swap(nums, i, j);
        }
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];

        int pivot = partition(nums, start, end);

        if (k <= pivot) {
            return quickSelect(nums, start, pivot, k);
        } else {
            return quickSelect(nums, pivot + 1, end, k);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // kth largest = (n - k)th smallest
        return quickSelect(nums, 0, n - 1, n - k);
    }

    // Demo
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k)); // Output: 5

        int[] nums2 = {7, 10, 4, 3, 20, 15};
        int k2 = 3;
        System.out.println(findKthLargest(nums2, k2)); // Output: 10
    }
}
