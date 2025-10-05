package DSA.BinaryTree;

import DSA.utils.TreeUtils.Pair;
import DSA.utils.TreeUtils.TreeNode;

import java.util.*;

import static DSA.utils.TreeUtils.getTreeRoot;

public class BottomView {

    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            map.put(p.hd, p.node.val);

            if (p.node.left != null) queue.offer(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) queue.offer(new Pair(p.node.right, p.hd + 1));
        }

        res.addAll(map.values());
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

        System.out.println(bottomView(root)); // [9, 15, 20, 7]
    }
}
