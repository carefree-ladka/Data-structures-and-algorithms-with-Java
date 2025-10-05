package DSA.BinaryTree;

import DSA.utils.TreeUtils;
import DSA.utils.TreeUtils.TreeNode;

import static DSA.utils.TreeUtils.getTreeRoot;

public class MaximumDepthOfBinaryTree {

    // DFS Approach
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // BFS Approach
    public static int maxDepthBFS(TreeNode root) {
        return BreadthFirstSearch.maxDepth(root);
    }

    public static void main(String[] args) {
        /*
         *       3
         *      / \
         *     9   20
         *        /  \
         *       15   7
         */
        TreeUtils.TreeNode root = getTreeRoot();

        System.out.println(maxDepthBFS(root)); // 3
    }
}
