package DSA.FenwickTree;

class FenwickTree {
    private final int[] tree;
    private final int size;

    public FenwickTree(int n) {
        size = n;
        tree = new int[n + 1]; // 1-based indexing
    }

    // Update index i (0-based) with delta
    public void update(int i, int delta) {
        i++; // convert to 1-based index
        while (i <= size) {
            tree[i] += delta;
            i += i & -i; // move to parent
        }
    }

    // Query prefix sum up to index i (0-based)
    public int query(int i) {
        i++; // convert to 1-based index
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i; // move to parent
        }
        return sum;
    }

    // Query sum from l to r (0-based)
    public int queryRange(int l, int r) {
        return query(r) - query(l - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        FenwickTree ft = new FenwickTree(arr.length);

        // Build Fenwick Tree
        for (int i = 0; i < arr.length; i++) {
            ft.update(i, arr[i]);
        }

        System.out.println("Prefix sum up to index 3: " + ft.query(3)); // 1+2+3+4 = 10
        System.out.println("Sum from index 1 to 3: " + ft.queryRange(1, 3)); // 2+3+4=9

        // Update index 2 (arr[2] += 3)
        ft.update(2, 3);
        System.out.println("Prefix sum up to index 3 after update: " + ft.query(3)); // 1+2+6+4=13
    }
}

