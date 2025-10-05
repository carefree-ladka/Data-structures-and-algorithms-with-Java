package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBST {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) &&
                       validate(node.right, node.val, max);
    }

    public static boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        Long prev = null; // use Long to handle edge values safely

        while (curr != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            // Check BST property
            if (prev != null && curr.val <= prev) {
                return false;
            }
            prev = (long) curr.val;

            // Move to right subtree
            curr = curr.right;
        }
        return true;
    }

    public static void main(String[] args) {
        // Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Tree 1 valid? " + isValidBST(root1)); // true

        // Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Tree 2 valid? " + isValidBST(root2)); // false
    }
}
