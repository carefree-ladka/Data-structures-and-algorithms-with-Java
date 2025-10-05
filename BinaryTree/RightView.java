package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static DSA.utils.TreeUtils.getTreeRoot;

public class RightView {
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
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

        System.out.println(rightView(root));
    }
}
