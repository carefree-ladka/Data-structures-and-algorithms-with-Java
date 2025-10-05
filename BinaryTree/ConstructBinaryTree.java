package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

        // Map to store inorder value -> index
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd,
                                  int[] inorder, int inStart, int inEnd,
                                  Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // Root is the first element in preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root index in inorder
        int rootIndex = inorderMap.get(preorder[preStart]);

        // Number of nodes in left subtree
        int leftTreeSize = rootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, rootIndex - 1, inorderMap);

        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd, inorderMap);

        return root;
    }

    // Test cases
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root: " + root.val); // should be 3
        System.out.println("Left child: " + root.left.val); // should be 9
        System.out.println("Right child: " + root.right.val); // should be 20
    }
}
