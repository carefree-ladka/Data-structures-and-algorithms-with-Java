package DSA.BinaryTree.CoreTraversalOperations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void preorderRecursive(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public static List<Integer> preorderIterative(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>(List.of(root));

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // Push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return res;
    }

    public static List<Integer> morrisPreorder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // No left child → visit and move right
                res.add(curr.val);
                curr = curr.right;
            } else {
                // Find inorder predecessor
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // First time visiting → print, thread to curr, go left
                    res.add(curr.val);
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Thread already exists → remove thread, go right
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        preorderRecursive(root);
        System.out.println();
        System.out.println(preorderIterative(root)); // [1, 2, 4, 5, 3, 6, 7]
        System.out.println(morrisPreorder(root)); // [1, 2, 4, 5, 3, 6, 7]
    }
}
