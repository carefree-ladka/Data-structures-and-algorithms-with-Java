package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[]{p, q});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode node1 = pair[0], node2 = pair[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.offer(new TreeNode[]{node1.left, node2.left});
            queue.offer(new TreeNode[]{node1.right, node2.right});
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Identical trees
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        System.out.println(isSameTree(t1, t2));          // true
        System.out.println(isSameTreeBFS(t1, t2)); // true

        // Test Case 2: Different structure
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);

        TreeNode t4 = new TreeNode(1);
        t4.right = new TreeNode(2);

        System.out.println(isSameTree(t3, t4));          // false
        System.out.println(isSameTreeBFS(t3, t4)); // false
    }
}
