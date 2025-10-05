package DSA.BinaryTree.CoreTraversalOperations;

import java.util.*;

public class BFSBinaryTreeTraversals {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. Level Order Traversal (BFS)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    // 2. Zigzag Level Order Traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    // 3. Boundary Traversal (Anti-clockwise: root → left boundary → leaves → right boundary)
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    private static void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void addRightBoundary(TreeNode node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) res.add(stack.pop());
    }

    private static void addLeaves(TreeNode node, List<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        if (node.left != null) addLeaves(node.left, res);
        if (node.right != null) addLeaves(node.right, res);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // 4. Vertical Order Traversal
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.computeIfAbsent(p.col, k -> new ArrayList<>()).add(p.node.val);

            if (p.node.left != null) q.offer(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null) q.offer(new Pair(p.node.right, p.col + 1));
        }

        res.addAll(map.values());
        return res;
    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    // Demo
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order: " + levelOrder(root)); // [[1], [2, 3], [4, 5, 6, 7]]
        System.out.println("Zigzag Order: " + zigzagLevelOrder(root)); // [[1], [3, 2], [4, 5, 6, 7]]
        System.out.println("Boundary Traversal: " + boundaryTraversal(root)); // [1, 2, 4, 5, 6, 7, 3]
        System.out.println("Vertical Order: " + verticalOrder(root)); // [[4], [2], [1, 5, 6], [3], [7]]
    }
}
