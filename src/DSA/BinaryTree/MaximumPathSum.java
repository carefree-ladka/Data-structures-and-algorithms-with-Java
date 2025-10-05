package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import static DSA.utils.TreeUtils.getTreeRoot;

public class MaximumPathSum {
    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;

        // Get max path sum from left/right subtrees, ignoring negatives
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Update global maximum if the path goes through this node
        maxSum = Math.max(maxSum, node.val + left + right);

        // Return max sum path that can be extended to parent
        return node.val + Math.max(left, right);
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

        System.out.println(maxPathSum(root)); // 47
    }
}
