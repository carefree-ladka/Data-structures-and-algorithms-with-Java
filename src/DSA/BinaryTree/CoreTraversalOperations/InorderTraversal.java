package DSA.BinaryTree.CoreTraversalOperations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {

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

    /* ---------------- Recursive ---------------- */
    public static void inorderRecursive(TreeNode root) {
        if (root == null) return;

        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    /* ---------------- Iterative ---------------- */
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Process node
            curr = stack.pop();
            res.add(curr.val);

            // Visit right subtree
            curr = curr.right;
        }

        return res;
    }

    /* ---------------- Morris Inorder ---------------- */
    public static List<Integer> morrisInorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

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
                    // Create a thread and move left
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Thread already exists → remove thread and visit
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    /* ---------------- Driver ---------------- */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Inorder Recursive: ");
        inorderRecursive(root); // 4 2 5 1 6 3 7
        System.out.println();

        System.out.println("Inorder Iterative: " + inorderIterative(root)); // [4, 2, 5, 1, 6, 3, 7]
        System.out.println("Morris Inorder: " + morrisInorder(root));       // [4, 2, 5, 1, 6, 3, 7]
    }
}
