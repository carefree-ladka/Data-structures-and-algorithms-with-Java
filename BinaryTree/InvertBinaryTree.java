package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static DSA.utils.TreeUtils.getTreeRoot;
import static DSA.utils.TreeUtils.inOrder;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Swap children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
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
        inOrder(invertTree(root), new ArrayList<>());
        System.out.println(inOrder(invertTree(root), new ArrayList<>())); // [3, 9, 20, 15, 7]
    }
}
