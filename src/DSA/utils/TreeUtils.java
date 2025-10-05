package DSA.utils;

import java.util.List;

public class TreeUtils {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        public TreeNode node;
        public int hd;

        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private TreeUtils() {
    }

    public static TreeNode getTreeRoot() {
        /*
         * 3
         * / \
         * 9 20
         * / \
         * 15 7
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    public static List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        inOrder(root.left, list);
        inOrder(root.right, list);
        return list;
    }

    public static TreeNode insertBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insertBST(root.left, val);
        else
            root.right = insertBST(root.right, val);
        return root;
    }
}
