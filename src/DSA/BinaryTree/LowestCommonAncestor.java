package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }

    public static TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        //        6
        //      /   \
        //     2     8
        //    / \   / \
        //   0   4 7   9
        //      / \
        //     3   5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Test Case 1: LCA of 2 and 8
        TreeNode p1 = root.left;    // 2
        TreeNode q1 = root.right;   // 8
        System.out.println("LCA of 2 and 8: " + lowestCommonAncestor(root, p1, q1).val); // 6

        // Test Case 2: LCA of 2 and 4
        TreeNode p2 = root.left;         // 2
        TreeNode q2 = root.left.right;   // 4
        System.out.println("LCA of 2 and 4: " + lowestCommonAncestor(root, p2, q2).val); // 2

        // Test Case 3: LCA of 3 and 5
        TreeNode p3 = root.left.right.left;   // 3
        TreeNode q3 = root.left.right.right;  // 5
        System.out.println("LCA of 3 and 5: " + lowestCommonAncestor(root, p3, q3).val); // 4

        // Test Case 4: LCA of 7 and 9
        TreeNode p4 = root.right.left;   // 7
        TreeNode q4 = root.right.right;  // 9
        System.out.println("LCA of 7 and 9: " + lowestCommonAncestor(root, p4, q4).val); // 8

        // Test Case 5: LCA of 3 and 9
        TreeNode p5 = root.left.right.left;  // 3
        TreeNode q5 = root.right.right;      // 9
        System.out.println("LCA of 3 and 9: " + lowestCommonAncestor(root, p5, q5).val); // 6
    }
}