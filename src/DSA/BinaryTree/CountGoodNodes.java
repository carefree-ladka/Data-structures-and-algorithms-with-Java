package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

public class CountGoodNodes {

    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;
        if (node.val >= maxSoFar) count = 1;

        maxSoFar = Math.max(maxSoFar, node.val);

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        //       3
        //      / \
        //     1   4
        //    /   / \
        //   3   1   5
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Good nodes count: " + goodNodes(root)); // 4
    }
}
