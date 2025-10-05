package DSA.SegmentTree;

class SegmentTree {
    private final int[] tree;
    private final int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[2 * n];
        build(arr);
    }

    // Build the Segment Tree
    private void build(int[] arr) {
        // Insert leaf nodes
        if (n >= 0) System.arraycopy(arr, 0, tree, n, n);

        // Build internal nodes
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    // Update the value at index idx to newValue
    public void update(int idx, int newValue) {
        idx += n; // move to leaf
        tree[idx] = newValue;

        // Recalculate parents
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
        }
    }

    // Query sum in range [left, right)
    public int query(int left, int right) {
        left += n;
        right += n;
        int sum = 0;

        while (left < right) {
            if ((left & 1) == 1) { // left is odd
                sum += tree[left];
                left++;
            }
            if ((right & 1) == 1) { // right is odd
                right--;
                sum += tree[right];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);

        // Query sum from index 1 to 4 (3 + 5 + 7)
        System.out.println(segTree.query(1, 4)); // 15

        // Update value at index 2 to 6
        segTree.update(2, 6);

        // Query sum again from index 1 to 4 (3 + 6 + 7)
        System.out.println(segTree.query(1, 4)); // 16
    }
}
