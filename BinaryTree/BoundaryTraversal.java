package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);

        // Left boundary (excluding leaves)
        addLeftBoundary(root.left, res);

        // All leaves
        addLeaves(root.left, res);
        addLeaves(root.right, res);

        // Right boundary (excluding leaves, bottom-up)
        addRightBoundary(root.right, res);

        return res;
    }

    private static void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private static void addRightBoundary(TreeNode node, List<Integer> res) {
        List<Integer> tmp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) tmp.add(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        // add bottom-up
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }
    }

    private static void addLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        List<Integer> boundary = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundary);
        // Example Output: [1, 2, 4, 8, 9, 10, 11, 7, 3]
    }
}
