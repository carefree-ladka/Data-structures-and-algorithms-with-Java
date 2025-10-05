package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import static DSA.BinaryTree.SameTree.isSameTree;

public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        // Recurse on left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot)); // true

        // Another test case
        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(3);

        System.out.println(isSubtree(root, subRoot2)); // false
    }
}
