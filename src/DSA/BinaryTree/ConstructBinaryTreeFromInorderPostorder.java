package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderPostorder {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        // Map to store inorder value -> index
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode build(int[] postorder, int postStart, int postEnd,
                                  int[] inorder, int inStart, int inEnd,
                                  Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        // Root is the last element in postorder
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Find root index in inorder
        int rootIndex = inorderMap.get(postorder[postEnd]);

        // Number of nodes in left subtree
        int leftTreeSize = rootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = build(postorder, postStart, postStart + leftTreeSize - 1,
                inorder, inStart, rootIndex - 1, inorderMap);

        root.right = build(postorder, postStart + leftTreeSize, postEnd - 1,
                inorder, rootIndex + 1, inEnd, inorderMap);

        return root;
    }

    // Test cases
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);
        System.out.println("Root: " + root.val); // should be 3
        System.out.println("Left child: " + root.left.val); // should be 9
        System.out.println("Right child: " + root.right.val); // should be 20
    }
}
