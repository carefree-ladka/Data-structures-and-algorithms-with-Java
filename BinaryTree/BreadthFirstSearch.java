package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.*;

import static DSA.utils.TreeUtils.getTreeRoot;

public class BreadthFirstSearch {

    // 1. BFS / Level Order Traversal (returns list of values)
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return result;
    }

    // 2. Level Order Traversal by Level (returns list of list)
    public static List<List<Integer>> levelOrderByLevel(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // 3. Maximum Depth using BFS
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }

    // 4. Minimum Depth using BFS
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) return depth;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            depth++;
        }

        return depth;
    }

    // 5. Check if tree contains a value using BFS
    public static boolean contains(TreeNode root, int target) {
        if (root == null) return false;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == target) return true;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return false;
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

        System.out.println("Level Order: " + levelOrder(root)); // [3, 9, 20, 15, 7]
        System.out.println("Level Order By Level: " + levelOrderByLevel(root)); // [[3], [9, 20], [15, 7]]
        System.out.println("Max Depth: " + maxDepth(root)); // 3
        System.out.println("Min Depth: " + minDepth(root)); // 2
        System.out.println("Contains 5? " + contains(root, 5)); // false
        System.out.println("Contains 10? " + contains(root, 10)); // false
    }
}
