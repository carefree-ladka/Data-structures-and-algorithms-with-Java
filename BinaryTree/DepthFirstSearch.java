package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static DSA.utils.TreeUtils.getTreeRoot;

public class DepthFirstSearch {

    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> depthFirstSearch(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>(List.of(root));

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
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

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(depthFirstSearch(root));
    }
}
