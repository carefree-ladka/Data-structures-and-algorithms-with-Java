package DSA.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import DSA.utils.TreeUtils.TreeNode;
import static DSA.utils.TreeUtils.getTreeRoot;

public class LeftView {
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) res.add(node.val);
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

        System.out.println(leftView(root));
    }
}
