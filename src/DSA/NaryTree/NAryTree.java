package DSA.NaryTree;

import java.util.*;

public class NAryTree {

    public static class Node {
        private final int val;
        private final List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        // Getter methods for better encapsulation
        public int getVal() {
            return val;
        }

        public List<Node> getChildren() {
            return children;
        }

        // Add child helper method
        public void addChild(Node child) {
            if (child != null) {
                this.children.add(child);
            }
        }

        // Add multiple children
        public void addChildren(Node... children) {
            for (Node child : children) {
                addChild(child);
            }
        }
    }

    // ==================== TRAVERSAL METHODS ====================

    /**
     * Depth-First Search traversal
     */
    public static void dfs(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        for (Node child : root.children) {
            dfs(child);
        }
    }

    /**
     * Pre-order traversal (root -> children)
     */
    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        for (Node child : root.children) {
            preOrder(child);
        }
    }

    /**
     * Post-order traversal (children -> root)
     */
    public static void postOrder(Node root) {
        if (root == null) return;

        for (Node child : root.children) {
            postOrder(child);
        }

        System.out.print(root.val + " ");
    }

    /**
     * Level-order traversal (Breadth-First Search)
     */
    public static List<Integer> bfs(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.val);

            for (Node child : current.children) {
                queue.offer(child);
            }
        }
        return result;
    }

    /**
     * Level-order traversal returning list of lists (each level separately)
     */
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                assert current != null;
                currentLevel.add(current.val);

                for (Node child : current.children) {
                    queue.offer(child);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // ==================== SEARCH METHODS ====================

    /**
     * Search for a value in the tree using DFS
     */
    public static boolean search(Node root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        for (Node child : root.children) {
            if (search(child, target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find a node with the given value
     */
    public static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;

        for (Node child : root.children) {
            Node found = findNode(child, target);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    /**
     * Find path from root to target node
     */
    public static List<Integer> findPath(Node root, int target) {
        List<Integer> path = new ArrayList<>();
        if (findPathHelper(root, target, path)) {
            return path;
        }
        return new ArrayList<>(); // Return empty list if not found
    }

    private static boolean findPathHelper(Node root, int target, List<Integer> path) {
        if (root == null) return false;

        path.add(root.val);

        if (root.val == target) {
            return true;
        }

        for (Node child : root.children) {
            if (findPathHelper(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1); // Backtrack
        return false;
    }

    // ==================== TREE PROPERTIES ====================

    /**
     * Calculate the height/depth of the tree
     */
    public static int height(Node root) {
        if (root == null) return 0;

        int maxHeight = 0;
        for (Node child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return 1 + maxHeight;
    }

    /**
     * Count total number of nodes in the tree
     */
    public static int size(Node root) {
        if (root == null) return 0;

        int count = 1; // Count current node
        for (Node child : root.children) {
            count += size(child);
        }
        return count;
    }

    /**
     * Count number of leaf nodes
     */
    public static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;

        int leafCount = 0;
        for (Node child : root.children) {
            leafCount += countLeaves(child);
        }
        return leafCount;
    }

    /**
     * Find maximum value in the tree
     */
    public static int findMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int max = root.val;
        for (Node child : root.children) {
            max = Math.max(max, findMax(child));
        }
        return max;
    }

    /**
     * Find minimum value in the tree
     */
    public static int findMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int min = root.val;
        for (Node child : root.children) {
            min = Math.min(min, findMin(child));
        }
        return min;
    }

    /**
     * Calculate sum of all node values
     */
    public static int sum(Node root) {
        if (root == null) return 0;

        int total = root.val;
        for (Node child : root.children) {
            total += sum(child);
        }
        return total;
    }

    // ==================== TREE COMPARISON ====================

    /**
     * Check if two trees are identical
     */
    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        if (root1.children.size() != root2.children.size()) return false;

        for (int i = 0; i < root1.children.size(); i++) {
            if (!isIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }
        return true;
    }

    // ==================== TREE MODIFICATION ====================

    /**
     * Create a deep copy of the tree
     */
    public static Node clone(Node root) {
        if (root == null) return null;

        Node cloned = new Node(root.val);
        for (Node child : root.children) {
            cloned.children.add(clone(child));
        }
        return cloned;
    }

    /**
     * Mirror/flip the tree (reverse children order)
     */
    public static void mirror(Node root) {
        if (root == null) return;

        Collections.reverse(root.children);
        for (Node child : root.children) {
            mirror(child);
        }
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Print tree structure with indentation
     */
    public static void printTree(Node root) {
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(Node root, int depth) {
        if (root == null) return;

        // Print indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(root.val);

        for (Node child : root.children) {
            printTreeHelper(child, depth + 1);
        }
    }

    /**
     * Get all nodes at a specific level
     */
    public static List<Integer> getNodesAtLevel(Node root, int level) {
        List<Integer> result = new ArrayList<>();
        getNodesAtLevelHelper(root, level, 0, result);
        return result;
    }

    private static void getNodesAtLevelHelper(Node root, int targetLevel, int currentLevel, List<Integer> result) {
        if (root == null) return;

        if (currentLevel == targetLevel) {
            result.add(root.val);
            return;
        }

        for (Node child : root.children) {
            getNodesAtLevelHelper(child, targetLevel, currentLevel + 1, result);
        }
    }

    /**
     * Check if tree is balanced (difference in height between any subtrees <= 1)
     */
    public static boolean isBalanced(Node root) {
        return checkBalanced(root) != -1;
    }

    private static int checkBalanced(Node root) {
        if (root == null) return 0;

        List<Integer> childHeights = new ArrayList<>();
        for (Node child : root.children) {
            int childHeight = checkBalanced(child);
            if (childHeight == -1) return -1; // Unbalanced
            childHeights.add(childHeight);
        }

        if (!childHeights.isEmpty()) {
            int maxHeight = Collections.max(childHeights);
            int minHeight = Collections.min(childHeights);
            if (maxHeight - minHeight > 1) return -1; // Unbalanced
        }

        return 1 + (childHeights.isEmpty() ? 0 : Collections.max(childHeights));
    }

    // ==================== DEMO METHODS ====================

    /**
     * Build sample tree for testing
     */
    public static Node buildSampleTree() {
        Node root = new Node(1);

        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);

        Node child4 = new Node(5);
        Node child5 = new Node(6);
        Node child6 = new Node(7);
        Node child7 = new Node(8);

        root.addChildren(child1, child2, child3);
        child2.addChildren(child4, child5);
        child3.addChildren(child6, child7);

        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== N-ary Tree Operations Demo ===\n");

        Node root = buildSampleTree();

        System.out.println("Tree structure:");
        printTree(root);
        System.out.println();

        System.out.println("=== Traversals ===");
        System.out.print("DFS/Pre-order: ");
        dfs(root);
        System.out.println();

        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();

        System.out.println("BFS/Level-order: " + bfs(root));
        System.out.println("Level-by-level: " + levelOrder(root));
        System.out.println();

        System.out.println("=== Tree Properties ===");
        System.out.println("Height: " + height(root));
        System.out.println("Size: " + size(root));
        System.out.println("Leaf count: " + countLeaves(root));
        System.out.println("Max value: " + findMax(root));
        System.out.println("Min value: " + findMin(root));
        System.out.println("Sum: " + sum(root));
        System.out.println("Is balanced: " + isBalanced(root));
        System.out.println();

        System.out.println("=== Search Operations ===");
        int target = 6;
        System.out.println("Search for " + target + ": " + search(root, target));
        System.out.println("Path to " + target + ": " + findPath(root, target));
        System.out.println("Nodes at level 2: " + getNodesAtLevel(root, 2));
        System.out.println();

        System.out.println("=== Tree Modification ===");
        Node cloned = clone(root);
        System.out.println("Original and cloned are identical: " + isIdentical(root, cloned));

        mirror(cloned);
        System.out.println("After mirroring clone:");
        printTree(cloned);
    }
}