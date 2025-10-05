package DSA.QuadTree;

// Definition for a DSA.QuadTree node
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class QuadTree {

    public static Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private static Node helper(int[][] grid, int i, int j, int w) {
        if (allSame(grid, i, j, w)) {
            return new Node(grid[i][j] == 1, true);
        }

        Node node = new Node(true, false);
        node.topLeft = helper(grid, i, j, w / 2);
        node.topRight = helper(grid, i, j + w / 2, w / 2);
        node.bottomLeft = helper(grid, i + w / 2, j, w / 2);
        node.bottomRight = helper(grid, i + w / 2, j + w / 2, w / 2);
        return node;
    }

    private static boolean allSame(int[][] grid, int i, int j, int w) {
        for (int x = i; x < i + w; ++x)
            for (int y = j; y < j + w; ++y)
                if (grid[x][y] != grid[i][j])
                    return false;
        return true;
    }

    public static void printQuadTree(Node node, String indent) {
        if (node == null)
            return;

        if (node.isLeaf) {
            System.out.println(indent + "Leaf: " + node.val);
        } else {
            System.out.println(indent + "Node:");
            printQuadTree(node.topLeft, indent + "  topLeft -> ");
            printQuadTree(node.topRight, indent + "  topRight -> ");
            printQuadTree(node.bottomLeft, indent + "  bottomLeft -> ");
            printQuadTree(node.bottomRight, indent + "  bottomRight -> ");
        }
    }

    // Test usage
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 },
                { 0, 0, 1, 1 }
        };

        Node root = construct(grid);
        printQuadTree(root, "");
    }
}
