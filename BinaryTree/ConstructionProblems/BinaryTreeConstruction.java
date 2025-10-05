package DSA.BinaryTree.ConstructionProblems;

import java.util.*;

public class BinaryTreeConstruction {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // -------------------------------
    // 1. Construct Binary Tree from Preorder & Inorder
    // -------------------------------
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int ps, int pe,
                                       int[] in, int is, int ie,
                                       Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
        int inRoot = inMap.get(root.val);
        int leftSize = inRoot - is;

        root.left = buildPreIn(pre, ps + 1, ps + leftSize,
                in, is, inRoot - 1, inMap);
        root.right = buildPreIn(pre, ps + leftSize + 1, pe,
                in, inRoot + 1, ie, inMap);
        return root;
    }

    // -------------------------------
    // 2. Construct Binary Tree from Inorder & Postorder
    // -------------------------------
    public static TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildInPost(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildInPost(int[] post, int ps, int pe,
                                        int[] in, int is, int ie,
                                        Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(post[pe]);
        int inRoot = inMap.get(root.val);
        int leftSize = inRoot - is;

        root.left = buildInPost(post, ps, ps + leftSize - 1,
                in, is, inRoot - 1, inMap);
        root.right = buildInPost(post, ps + leftSize, pe - 1,
                in, inRoot + 1, ie, inMap);
        return root;
    }

    // -------------------------------
    // 3. Construct BST from Preorder
    // -------------------------------
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstHelper(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode bstHelper(int[] pre, int[] idx, int min, int max) {
        if (idx[0] >= pre.length) return null;

        int val = pre[idx[0]];
        if (val < min || val > max) return null;

        idx[0]++;
        TreeNode root = new TreeNode(val);
        root.left = bstHelper(pre, idx, min, val);
        root.right = bstHelper(pre, idx, val, max);
        return root;
    }

    // -------------------------------
    // 4. Serialize and Deserialize Binary Tree (FIXED)
    // -------------------------------

    // Serialize: Convert tree to string using preorder traversal
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    private static void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    // Deserialize: Convert string back to tree
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeDFS(nodes);
    }

    private static TreeNode deserializeDFS(Deque<String> nodes) {
        String val = nodes.poll();
        if (val.equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeDFS(nodes);
        root.right = deserializeDFS(nodes);
        return root;
    }

    // -------------------------------
    // 5. Clone a Binary Tree
    // -------------------------------
    public static TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);

        return newNode;
    }

    // -------------------------------
    // Alternative Level-order Serialize/Deserialize (BFS approach)
    // -------------------------------

    public static String serializeLevelOrder(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("N,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    public static TreeNode deserializeLevelOrder(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = queue.poll();

            // Left child
            if (!nodes[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.offer(left);
            }

            // Right child
            if (++i < nodes.length && !nodes[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    // -------------------------------
    // Utility: Print tree for testing
    // -------------------------------
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // -------------------------------
    // Demo
    // -------------------------------
    public static void main(String[] args) {
        // Construct from Preorder & Inorder
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root1 = buildTreeFromPreIn(preorder, inorder);

        // Construct from Inorder & Postorder
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root2 = buildTreeFromInPost(inorder, postorder);

        // Construct BST from Preorder
        int[] bstPre = {8, 5, 1, 7, 10, 12};
        TreeNode bst = bstFromPreorder(bstPre);

        // Test Serialize & Deserialize (DFS - Preorder)
        System.out.println("=== DFS Serialization ===");
        String serializedDFS = serialize(root1);
        System.out.println("Serialized (DFS): " + serializedDFS);
        TreeNode deserializedDFS = deserialize(serializedDFS);
        System.out.print("Deserialized tree (inorder): ");
        printInorder(deserializedDFS);
        System.out.println();

        // Test Level-order Serialize & Deserialize (BFS)
        System.out.println("\n=== BFS Serialization ===");
        String serializedBFS = serializeLevelOrder(root1);
        System.out.println("Serialized (BFS): " + serializedBFS);
        TreeNode deserializedBFS = deserializeLevelOrder(serializedBFS);
        System.out.print("Deserialized tree (inorder): ");
        printInorder(deserializedBFS);
        System.out.println();

        // Test Clone
        System.out.println("\n=== Clone Tree ===");
        TreeNode cloned = cloneTree(root1);
        System.out.println("Original root value: " + root1.val);
        System.out.println("Cloned root value: " + cloned.val);
        System.out.print("Cloned tree (inorder): ");
        printInorder(cloned);
        System.out.println();

        // Verify they are different objects
        System.out.println("Are they the same object? " + (root1 == cloned));
        System.out.println("Do they have the same structure? " + treesEqual(root1, cloned));
    }

    // Helper method to check if two trees are structurally identical
    private static boolean treesEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val &&
                       treesEqual(t1.left, t2.left) &&
                       treesEqual(t1.right, t2.right);
    }
}