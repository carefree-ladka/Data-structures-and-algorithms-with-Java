package DSA.BinaryTree;

import DSA.utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static DSA.utils.TreeUtils.getTreeRoot;

public class SerializeDeserializeTree {

    // Serialize: Tree -> DSA.String
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,"); // mark null
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize: DSA.String -> Tree
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private static TreeNode deserializeHelper(Deque<String> nodes) {
        if (nodes.isEmpty()) return null;

        String val = nodes.poll();
        if (val.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    // Test cases
    public static void main(String[] args) {
        /*
         *       3
         *      / \
         *     9   20
         *        /  \
         *       15   7
         */
        TreeNode root = getTreeRoot();
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        String serializedAgain = serialize(deserialized);
        System.out.println("Serialized Again: " + serializedAgain);
    }
}
