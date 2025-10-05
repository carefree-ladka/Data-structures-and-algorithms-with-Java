package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestBST {

    private static int count, result;

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        result = -1;
        inorder(root);
        return result;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        count--;
        if (count == 0) {
            result = node.val;
            return; // stop early
        }

        inorder(node.right);
    }

    public static int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;

            curr = curr.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
              3
             / \
            1   4
             \
              2
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println("Kth smallest (k=1): " + kthSmallest(root, 1)); // 1
        System.out.println("Kth smallest (k=2): " + kthSmallest(root, 2)); // 2
        System.out.println("Kth smallest (k=3): " + kthSmallest(root, 3)); // 3
        System.out.println("Kth smallest (k=4): " + kthSmallest(root, 4)); // 4
    }
}
