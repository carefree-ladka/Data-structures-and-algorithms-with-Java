package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static DSA.utils.TreeUtils.getTreeRoot;

public class BinaryTreeBasics {
    // Maximum Depth (DFS)
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // Minimum Depth (BFS)
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            depth++;
        }

        return depth;
    }

    // Count of Leaf Nodes (DFS)
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // Diameter of Tree
    public static int diameter(TreeNode root) {
        int[] max = new int[1];
        diameterHelper(root, max);
        return max[0];
    }

    private static int diameterHelper(TreeNode node, int[] max) {
        if (node == null) return 0;

        int left = diameterHelper(node.left, max);
        int right = diameterHelper(node.right, max);

        max[0] = Math.max(max[0], left + right); // path through this node
        return Math.max(left, right) + 1;
    }

    // Check if tree is height-balanced
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        /*
         *       3
         *      / \
         *     9   20
         *        /  \
         *       15   7
         */
        TreeNode root = getTreeRoot();

        System.out.println("Max Depth: " + maxDepth(root));       // 3
        System.out.println("Min Depth: " + minDepth(root));       // 2
        System.out.println("Leaf Count: " + countLeaves(root));   // 3
        System.out.println("Diameter: " + diameter(root));        // 3
        System.out.println("Is Balanced: " + isBalanced(root));   // true
    }
}
