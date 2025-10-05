package DSA.BinaryTree.CoreTraversalOperations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal {

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
    public static void postorderRecursive(TreeNode root) {
        if (root == null) return;

        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    /* ---------------- Iterative (Two Stacks) ---------------- */
    public static List<Integer> postorderIterativeTwoStacks(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }

        return res;
    }

    /* ---------------- Iterative (One DSA.Stack) ---------------- */
    public static List<Integer> postorderIterativeOneStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    res.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return res;
    }

    /* ---------------- Morris Postorder ---------------- */
    public static List<Integer> morrisPostorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode curr = dummy;

        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Reverse the path from curr.left to pred
                    addReverse(curr.left, pred, res);
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }

        return res;
    }

    private static void addReverse(TreeNode from, TreeNode to, List<Integer> res) {
        reversePath(from, to);
        TreeNode node = to;
        while (true) {
            res.add(node.val);
            if (node == from) break;
            node = node.right;
        }
        reversePath(to, from);
    }

    private static void reversePath(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode x = from, y = from.right, z;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to) break;
        }
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

        System.out.print("Postorder Recursive: ");
        postorderRecursive(root); // 4 5 2 6 7 3 1
        System.out.println();

        System.out.println("Postorder Iterative (Two Stacks): " + postorderIterativeTwoStacks(root)); //  [4, 5, 2, 6, 7, 3, 1]
        System.out.println("Postorder Iterative (One DSA.Stack): " + postorderIterativeOneStack(root)); // [4, 5, 2, 6, 7, 3, 1]
        System.out.println("Morris Postorder: " + morrisPostorder(root)); // [4, 5, 2, 6, 7, 3, 1]
    }
}
