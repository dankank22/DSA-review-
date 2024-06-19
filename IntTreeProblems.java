package problems;

import datastructures.IntTree;
// Checkstyle will complain that this is an unused import until you use it in your code.
import datastructures.IntTree.IntTreeNode;

/**
 * See the spec on the website for tips and example behavior.
 *
 * Also note: you may want to use private helper methods to help you solve these problems.
 * YOU MUST MAKE THE PRIVATE HELPER METHODS STATIC, or else your code will not compile.
 * This happens for reasons that aren't the focus of this assignment and are mostly skimmed over in
 * 142 and 143. If you want to know more, you can ask on the discussion board or at office hours.
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not call any methods on the `IntTree` objects
 * - do not construct new `IntTreeNode` objects (though you may have as many `IntTreeNode` variables
 *      as you like).
 * - do not construct any external data structures such as arrays, queues, lists, etc.
 * - do not mutate the `data` field of any node; instead, change the tree only by modifying
 *      links between nodes.
 */

public class IntTreeProblems {

    /**
     * Computes and returns the sum of the values multiplied by their depths in the given tree.
     * (The root node is treated as having depth 1.)
     */
    public static int depthSum(IntTree tree) {
        int sum = 0;
        IntTreeNode root = tree.overallRoot;
        int count = 1;
        sum = depthSum(tree.overallRoot, sum, count);
        return sum;
    }

    private static int depthSum(IntTreeNode root, int s, int c) {
        if (root != null) {
            s = root.data * c;
            int leftTreeSum = depthSum(root.left, s, c+1);
            int rightTreeSum = depthSum(root.right, s, c+1);
            return s + rightTreeSum + leftTreeSum;
        }
        else {
            return 0;
        }
    }

    /**
     * Removes all leaf nodes from the given tree.
     */
    public static void removeLeaves(IntTree tree) {
        IntTreeNode root = tree.overallRoot;
        tree.overallRoot = removeLeaves(root);
    }

    private static IntTreeNode removeLeaves(IntTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    /**
     * Removes from the given BST all values less than `min` or greater than `max`.
     * (The resulting tree is still a BST.)
     */
    public static void trim(IntTree tree, int min, int max) {
        IntTreeNode root = tree.overallRoot;
        tree.overallRoot = trim(root, min, max);
    }

    private static IntTreeNode trim(IntTreeNode root, int min, int max) {
        if (root != null) {
            root.left = trim(root.left, min, max);
            root.right = trim(root.right, min, max);
            if (root.data > max) {
                return root.left;
            }
            else if (root.data < min) {
                return root.right;
            }
            else {
                return root;
            }
        }
        return root;
    }
}
